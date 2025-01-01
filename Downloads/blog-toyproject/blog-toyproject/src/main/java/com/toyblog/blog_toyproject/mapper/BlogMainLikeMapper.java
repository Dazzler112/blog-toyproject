package com.toyblog.blog_toyproject.mapper;

import org.apache.ibatis.annotations.*;

import com.toyblog.blog_toyproject.dto.*;

@Mapper
public interface BlogMainLikeMapper {
	
	@Delete("""
			DELETE 
			FROM
			BOARDLIKE
			WHERE 
				board_id = #{board_id}
			AND
				member_id = #{member_id}
			""")
	Integer deleteLike(BoardLike boardLike);

	@Insert("""
			INSERT
			INTO
			BOARDLIKE
			VALUES 
				  (
				   #{board_id}
				 , #{member_id}
				  )
			""")
	Integer insertLike(BoardLike boardLike);

	@Select("""
			SELECT 
				COUNT(*)
			FROM
			BOARDLIKE
			WHERE
				board_id = #{board_id}
			""")
	Integer likeCountBoardId(Integer board_id);

	//like 누르면 유지
	@Select("""
			SELECT
			*
			FROM
			BOARDLIKE
			WHERE
				board_id = #{board_id}
			AND
				member_id = #{member_id}
			""")
	BoardLike selectLike(Integer board_id, String member_id);

	@Delete("""
			DELETE
			FROM
			BOARDLIKE
			WHERE
			board_id = #{board_id}
			""")
	Integer deleteByBoardId(Integer board_id);
	
	

}
