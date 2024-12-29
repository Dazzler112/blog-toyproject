package com.toyblog.blog_toyproject.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.toyblog.blog_toyproject.dto.*;

@Mapper
public interface BlogMainMapper {

	@Insert("""
			INSERT INTO 
			BOARD(title, body, writer, write_date, category)
			VALUES(#{title}, #{body}, #{writer}, #{write_date}, #{category})
			""")
	@Options(useGeneratedKeys = true, keyProperty = "board_id")
	Integer insertBoard(Board board);

	@Insert("""
			INSERT INTO
			PHOTO(board_id, photo_name)
			VALUES(#{board_id}, #{photo_name})
			""")
	Integer insertFileName(Integer board_id, String photo_name);

	@Select("""
			SELECT
				b.board_id
			  , b.title
			  , b.body
			  , b.writer
			  , b.write_date
			  , b.category
			  , p.photo_name
			  ,
			  (
			   SELECT 
			   	COUNT(*)
			   FROM
			   BOARDLIKE
			   WHERE 	
			   	board_id = board_id
			  )	like_count
			FROM
			   BOARD b
			   LEFT JOIN
			   PHOTO p 
			   ON
			   b.board_id = p.board_id
			   ORDER BY board_id DESC
			""")
	@ResultMap("boardPageMap")
	List<Board> selectBoard();

	@Select("""
			SELECT
				b.board_id
			  , b.title
			  , b.body
			  , b.writer
			  , b.write_date
			  , b.category
			  , p.photo_name
			FROM
			   BOARD b
			   LEFT JOIN
			   PHOTO p 
			   ON
			   b.board_id = p.board_id
			   WHERE
			   b.board_id = #{board_id}
			""")
	@ResultMap("boardTotalMap")
	Board selectPostBoardId(Integer board_id);
	
	@Select("""
			SELECT 
			photo_name
			FROM
			PHOTO
			WHERE board_id = #{board_id}
			""")
	List<String> selectPhotoFile(Integer board_id);

	@Delete("""
			DELETE
			FROM
			PHOTO
			WHERE
			board_id = #{board_id}
			""")
	void deletePhotoBoardId(Integer board_id);

	@Delete("""
			DELETE
			FROM
			BOARD
			WHERE
			board_id = #{board_id}
			""")
	int deletePost(Integer board_id);

	@Delete("""
			DELETE
			FROM
			PHOTO
			WHERE
			board_id = #{board_id}
			AND
			photo_name = #{photo_name}
			""")
	void deletePhotoName(Integer board_id, String photo_name);

	@Insert("""
			INSERT
			INTO
			PHOTO
			     (
				  board_id
				, photo_name
				 )
			VALUES
				  (
				   #{board_id}
				 , #{photo_name}
				  )
			""")
	void updatePhotoName(Integer board_id, String photo_name);

	@Update("""
			UPDATE
			BOARD
			SET
				title = #{title}
			  ,	body = #{body}
			  , write_date = #{write_date}
			  , category = #{category}
			WHERE
			  board_id = #{board_id}
			""")
	int updateBoard(Board board);

	@Select("""
			SELECT
			  *
			FROM
			BOARDREPLY
			WHERE
			board_id = #{board_id}
			ORDER BY reply_id
			""")
	List<BoardReply> selectCommentbyBoardId(Integer board_id);

	@Select("""
			SELECT
			  *
			FROM
			BOARDREPLY
			WHERE
			reply_id = #{reply_id}
			""")
	BoardReply getCommentReplyId(Integer reply_id);

	@Insert("""
			INSERT
			INTO
			BOARDREPLY
					  (
					  board_id
					, comment_body
					, member_id
					, comment_date 
					  )
			VALUES
					  (
					  #{board_id}
					, #{comment_body}  
					, #{member_id}
					, #{comment_date}
					  )
			""")
	int addComment(BoardReply boardReply);

}
