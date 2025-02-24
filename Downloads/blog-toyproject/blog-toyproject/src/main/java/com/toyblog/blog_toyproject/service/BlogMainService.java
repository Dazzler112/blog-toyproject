package com.toyblog.blog_toyproject.service;

import java.io.*;
import java.util.*;

import org.jsoup.*;
import org.jsoup.safety.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.multipart.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.mapper.*;

import software.amazon.awssdk.core.sync.*;
import software.amazon.awssdk.services.s3.*;
import software.amazon.awssdk.services.s3.model.*;

@Service
public class BlogMainService {

	@Autowired
	private S3Client s3;
	
	@Value("${aws.s3.bucketName}")
	private String bucketName;
	
	@Autowired
	private BlogMainMapper blogMainMapper;

	@Autowired
	private BlogMainLikeMapper blogMainLikeMapper;
	
	@Autowired
	private BlogCommentMapper blogCommentMapper;
	
	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> addboard(Board board, MultipartFile[] files) throws IOException {
		
		Map<String, Object> result = new HashMap<>();
		
		int cnt = blogMainMapper.insertBoard(board);
		if (files != null && files.length > 0) { //사진파일이 null값이 아닐경우만 사진 삽입 실행
		for(MultipartFile file : files) {
			if(file.getSize() > 0) {
				blogMainMapper.insertFileName(board.getBoard_id(), file.getOriginalFilename());
				String ObjectKey = "review_blog_project/" + board.getBoard_id() + "/" + file.getOriginalFilename();
				
				PutObjectRequest putObjectRequest = PutObjectRequest.builder()
						.bucket(bucketName)
						.key(ObjectKey)
						.acl(ObjectCannedACL.PUBLIC_READ)
						.build();
				RequestBody requestBody = RequestBody.fromInputStream(file.getInputStream(), file.getSize());
				
				s3.putObject(putObjectRequest, requestBody);
			}
		}
		}
		result.put("selectPaginBoard", cnt);
		
		return result;
	}

	// 검색서치를 위해 메소드 바꿔야함
//	public List<Board> getBoardId(Authentication authentication) {
//		
//		List<Board> board = blogMainMapper.selectBoard();
//		
//		
//		if(authentication != null) {
//			for(Board boards : board) {
//				BoardLike boardLike = blogMainLikeMapper.selectLike(boards.getBoard_id(), authentication.getName());				
//				if(boardLike != null) {
//					boards.setLiked(true);
//				}
//			}
//		}	
//		
//		return board;
//	}

	public Map<String, Object> resultListMain(Authentication authentication, String search, String type) {
		
		Integer searchBar = blogMainMapper.countAll(search, type);
		
		Map<String, Object> allInfo = new HashMap<>();
		allInfo.put("searchPage", searchBar);
		
		List<Board> board = blogMainMapper.selectAllMainBoard(search, type);
		
		if(authentication != null) {
		for(Board boards : board) {
			BoardLike boardLike = blogMainLikeMapper.selectLike(boards.getBoard_id(), authentication.getName());				
			if(boardLike != null) {
				boards.setLiked(true);
			}
		}
	}	
		
		return Map.of("allInfo", allInfo,
					  "boardList", board);
	}
	
	public Board getPostBoardId(Integer board_id, Authentication authentication) {
		
		Board board = blogMainMapper.selectPostBoardId(board_id);
		
		if(authentication != null) {
			BoardLike boardLike = blogMainLikeMapper.selectLike(board_id, authentication.getName());
			if(boardLike != null) {
				board.setLiked(true);
			}
		}
		return board;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> removeMainPost(Integer board_id) {

		Map<String, Object> result = new HashMap<>();
		
		blogMainLikeMapper.deleteByBoardId(board_id);
		
		blogCommentMapper.deleteByBoardId(board_id);
		
		List<String> photoNames = blogMainMapper.selectPhotoFile(board_id);
		
		blogMainMapper.deletePhotoBoardId(board_id);
		
		for(String photoName : photoNames) {
			String photoKey = "review_blog_project/" + board_id + "/" + photoName;
			DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
					.bucket(bucketName)
					.key(photoKey)
					.build();
			
				s3.deleteObject(deleteObjectRequest);
		}
		
		int cnt = blogMainMapper.deletePost(board_id);
		
		result.put("deleteMain", cnt);
		
		return result;
	}

	public Map<String, Object> updatePost(Board board, List<String> removeFiles, MultipartFile[] addFile) throws IOException {
		
		Map<String, Object> result = new HashMap<>();
		
		if(removeFiles != null && !removeFiles.isEmpty()) {
			for(String fileName : removeFiles) {
				String fileKey = "review_blog_project/" + board.getBoard_id() + "/" + fileName;
				DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
							.bucket(bucketName)
							.key(fileKey)
							.build();
				
				s3.deleteObject(deleteObjectRequest);
				
				blogMainMapper.deletePhotoName(board.getBoard_id(), fileName);
			}
		}
		if (addFile != null && addFile.length > 0) {
		for(MultipartFile file : addFile) {
			if(file.getSize() > 0) {
				blogMainMapper.updatePhotoName(board.getBoard_id(), file.getOriginalFilename());
				
				String fileKey = "review_blog_project/" + board.getBoard_id() + "/" + file.getOriginalFilename();
				PutObjectRequest putObjectRequest = PutObjectRequest.builder()
						.acl(ObjectCannedACL.PUBLIC_READ)
						.bucket(bucketName)
						.key(fileKey)
						.build();
				
				RequestBody request = RequestBody.fromInputStream(file.getInputStream(), file.getSize());
				s3.putObject(putObjectRequest, request);
			}
		}
		}
		
		int cnt = blogMainMapper.updateBoard(board);
		
		result.put("modifyMain", cnt);
		
		return result;
	}

	public Map<String, Object> postCountLike(BoardLike boardLike, Authentication authentication) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("boardLike", false);
		
		boardLike.setMember_id(authentication.getName());
		Integer deleteLikeCnt = blogMainLikeMapper.deleteLike(boardLike);
		if(deleteLikeCnt != 1) {
			Integer insertLikeCnt = blogMainLikeMapper.insertLike(boardLike);
			result.put("boardLike", true);
		}
		Integer likeCount = blogMainLikeMapper.likeCountBoardId(boardLike.getBoard_id());
		result.put("likeCount", likeCount);
		
		return result;
	}

	public List<BoardReply> getCommentList(Integer board_id, Authentication authentication) {

		List<BoardReply> comments = blogCommentMapper.selectCommentbyBoardId(board_id);
		
		
		  if(authentication != null) {
		  
		  for(BoardReply comment : comments) {
		  comment.setEditable(comment.getMember_id().equals(authentication.getName()));
		  } }
		 
		
		return comments;
	}

	public BoardReply getReplyId(Integer reply_id) {
		
		return blogCommentMapper.getCommentReplyId(reply_id);

	}

	public Map<String, Object> addComment(BoardReply boardReply, Authentication authentication) {
		
		// 🚨 HTML 태그 제거
		String cleanComment = Jsoup.clean(boardReply.getComment_body(), Safelist.none());
		
		boardReply.setMember_id(authentication.getName());
		boardReply.setComment_body(cleanComment);		

		
		Map<String, Object> result = new HashMap<>();
		
		int cnt = blogCommentMapper.addComment(boardReply); 
		
		if(cnt == 1) {
			result.put("message", "comment add successful.");
		} else {
			result.put("message", "comment not added!");
		}
		
		return result;
	}

	public Map<String, Object> deleteCommentReply(Integer reply_id) {
		
		int cnt = blogCommentMapper.deleteComment(reply_id);
		
		Map<String, Object> result = new HashMap<>();
		
		if(cnt == 1) {
			result.put("message", "delete successful");
		}else {
			result.put("message", "somethings wrong..");
		}
		
		return result;
	}

	public Map<String, Object> commentUpdate(BoardReply boardReply) {
		
		// 🚨 HTML 태그 제거
		String cleanComment = Jsoup.clean(boardReply.getComment_body(), Safelist.none());
		boardReply.setComment_body(cleanComment);		
		
		int cnt = blogCommentMapper.updateComment(boardReply);

		
		Map<String, Object> result = new HashMap<>();
		
		if(cnt == 1) {
			result.put("message", "update successful");
		} else {
			result.put("message", "somethings wrong..");
		}
		
		return result;
	}

	public Map<String, Object> postingView(Integer board_id) {
		
		Map<String, Object> result = new HashMap<>();
		
		int cnt = blogMainMapper.blogPostingViews(board_id);
		
		result.put("postingView", cnt);
		
		return result;
	}

	public Map<String, Object> getPostContainer(Integer board_id, Authentication authentication) {
		
	    Map<String, Object> result = new HashMap<>();

	    // 이전 게시물 조회
	    Board pBoard = blogMainMapper.getPreviousPost(board_id);
	    if (pBoard != null && authentication != null) {
	        BoardLike boardLike = blogMainLikeMapper.selectLike(pBoard.getBoard_id(), authentication.getName());
	        if (boardLike != null) {
	            pBoard.setLiked(true);
	        }
	    }
	    result.put("previous", pBoard);

	    // 다음 게시물 조회
	    Board nBoard = blogMainMapper.getNextPost(board_id);
	    if (nBoard != null && authentication != null) {
	        BoardLike boardLike = blogMainLikeMapper.selectLike(nBoard.getBoard_id(), authentication.getName());
	        if (boardLike != null) {
	            nBoard.setLiked(true);
	        }
	    }
	    result.put("next", nBoard);

	    // 추가 이전 게시물
	    if (result.get("next") == null) { // 다음 게시물이 없는 경우
	        List<Board> exBoardList = blogMainMapper.getPreviousPostExtra(board_id, 2);
	        if (exBoardList != null && !exBoardList.isEmpty()) {
	            for (Board exBoard : exBoardList) {
	                if (authentication != null) {
	                    BoardLike boardLike = blogMainLikeMapper.selectLike(exBoard.getBoard_id(), authentication.getName());
	                    if (boardLike != null) {
	                        exBoard.setLiked(true);
	                    }
	                }
	            }
	            result.put("previousExtra", exBoardList); // 추가 이전 게시물 리스트 저장
	        }
	    }

	    return result;
	}


}
