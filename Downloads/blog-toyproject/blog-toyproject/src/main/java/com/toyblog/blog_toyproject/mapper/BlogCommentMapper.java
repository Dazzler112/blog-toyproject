package com.toyblog.blog_toyproject.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.toyblog.blog_toyproject.dto.*;

@Mapper
public interface BlogCommentMapper {

	
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

	@Delete("""
			DELETE
			FROM
			BOARDREPLY
			WHERE
			reply_id = #{reply_id}
			""")
	int deleteComment(Integer reply_id);

	@Update("""
			UPDATE
			BOARDREPLY
			SET
				comment_body = #{comment_body}
			  , comment_date = #{comment_date}
			WHERE
				reply_id = #{reply_id}
			""")
	int updateComment(BoardReply boardReply);
	
}
