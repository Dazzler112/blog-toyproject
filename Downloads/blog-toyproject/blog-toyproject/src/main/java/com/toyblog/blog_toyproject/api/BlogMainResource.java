package com.toyblog.blog_toyproject.api;

import java.io.*;
import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.format.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.service.*;

@RestController
public class BlogMainResource {

	@Autowired
	private BlogMainService blogMainService;
	
	@GetMapping("/post/{board_id}")
	public ResponseEntity<Board> getPostBoard(@PathVariable Integer board_id, 
											  Authentication authentication) {
		
		Board board = blogMainService.getPostBoardId(board_id, authentication);
		
		return ResponseEntity.ok(board);
	}

	@PostMapping(value = "/post/addpost", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void addMain(@RequestPart("photoFile") MultipartFile[] files, 
						@RequestParam("title") String title,
				        @RequestParam("body") String body,
				        @RequestParam("category") String category, 
				        @RequestParam("write_date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime writeDateStr,
				        Authentication authentication) throws IOException {
		
		// UTC 기준 시간 문자열을 Asia/Seoul 시간대로 변환
		ZonedDateTime seoulDateTime = ZonedDateTime.parse(writeDateStr + "+09:00")
				.withZoneSameInstant(ZoneId.of("Asia/Seoul"));
		LocalDateTime write_date = seoulDateTime.toLocalDateTime();
		
		Board board = new Board();
		board.setTitle(title);
		board.setBody(body);
		board.setCategory(category);
		board.setWrite_date(write_date);
		board.setWriter(authentication.getName());
		
		boolean add = blogMainService.addboard(board, files);
		
		if(!add) {
			throw new RuntimeException("게시글 등록 실패");
		}
	}
	
	@PostMapping("/post/remove")
	public void deletePost(@RequestBody Integer board_id) {
		
		boolean ok = blogMainService.removeMainPost(board_id);
	}	
	
	@PostMapping(value = "/post/modify/{board_id}" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void modifyPost(@PathVariable Integer board_id,
						   @RequestParam(value = "deletePhotoFile", required = false) List<String> removeFiles, 
						   @RequestPart(value = "photoFile", required = false) MultipartFile[] addFile, 
						   @RequestParam("title") String title,
				           @RequestParam("body") String body,
				           @RequestParam("category") String category, 
				           @RequestParam("write_date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime writeDateStr,
				           Authentication authentication) throws IOException {
		
		ZonedDateTime seoulDateTime = ZonedDateTime.parse(writeDateStr + "+09:00")
				.withZoneSameInstant(ZoneId.of("Asia/Seoul"));
		LocalDateTime write_date = seoulDateTime.toLocalDateTime();
		
		Board board = new Board();
		board.setBoard_id(board_id);
		board.setTitle(title);
		board.setBody(body);
		board.setCategory(category);
		board.setWrite_date(write_date);
		board.setWriter(authentication.getName());
		
		boolean ok = blogMainService.updatePost(board, removeFiles, addFile);
	}
	
	@PostMapping("/post/like")
	public ResponseEntity<Map<String, Object>> postLike(@RequestBody BoardLike boardLike,
														Authentication authentication) {
		
		if(authentication == null) {
			return ResponseEntity
						.status(403)
						.body(Map.of("message", "Please SignUp."));
		} else {
			return ResponseEntity
					.ok()
					.body(blogMainService.postCountLike(boardLike, authentication));
		}
	}
	
	@GetMapping("/post/comment")
	public List<BoardReply> commentList(@RequestParam("board_id") Integer board_id, 
									    Authentication authentication) {
		
		return blogMainService.getCommentList(board_id, authentication);
	}
	
	@GetMapping("/post/comment/{reply_id}")
	public BoardReply getCommentId(@PathVariable Integer reply_id) {
		
		return blogMainService.getReplyId(reply_id);
	}
	
	@PostMapping("/post/comment")
	public ResponseEntity<Map<String, Object>> addComment(@RequestBody BoardReply boardReply,
														  Authentication authentication) {
		
		if(authentication == null) {
			return ResponseEntity
					.status(403)
					.body(Map.of("message","Please SignUp."));
		} else {
			Map<String, Object> result = blogMainService.addComment(boardReply, authentication);
			return ResponseEntity
						.ok()
						.body(result);
		}
	}
	
	@DeleteMapping("/post/comment/{reply_id}")
	public ResponseEntity<Map<String, Object>> deleteComment(@PathVariable Integer reply_id) {
		
		Map<String, Object> result = blogMainService.deleteCommentReply(reply_id);
		
		return ResponseEntity
					.ok()
					.body(result);
	}
	
	@PutMapping("/post/comment/update")
	public ResponseEntity<Map<String, Object>> updateComment(@RequestBody BoardReply boardReply) {
		
		Map<String, Object> result = blogMainService.commentUpdate(boardReply);
		
		return ResponseEntity
				.ok()
				.body(result);
	}
}
