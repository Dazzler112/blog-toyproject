package com.toyblog.blog_toyproject.mapper;

import org.apache.ibatis.annotations.*;

import com.toyblog.blog_toyproject.dto.*;

@Mapper
public interface BlogAboutMapper {

// 나중에 Board의 Post에 사용		
//	@Select("""
//			SELECT
//				  about_id
//				, title
//				, member_id
//				, writer
//				, body
//				, about_date
//			FROM
//				ABOUT
//			WHERE
//				member_id = #{member_id}			
//			""")
//	About findByMemberId(String member_id);
	
	
	@Select("""
			SELECT
				  about_id
				, member_id
				, body
			FROM
				ABOUT
			WHERE
				about_id = #{about_id}
			""")
	About findByAboutId(Integer about_id);
	
//	@Insert("""
//			INSERT INTO 
//			ABOUT
//				(
//				  about_id
//				, title
//				, member_id
//				, writer
//				, body
//				, about_date
//				)
//			VALUES
//				(
//				    #{about_id}
//				  , #{title}
//				  , #{member_id}
//				  , #{writer}
//				  , #{body}
//				  , #{about_date}
//				)
//			""")
//	int addAboutBody(About about);
	
	@Insert("""
			INSERT INTO 
			ABOUT
				(
				  member_id
				, body
				)
			VALUES
				(
				  #{member_id}
				, #{body}
				)
			""")
	@Options(useGeneratedKeys = true, keyProperty = "about_id")	
	int addAboutBody(About about);
	
	


	// 업데이트 수정중 삭제로직인데 추후 사이트 만들어보고 확인
//	@Delete("""
//			DELETE 
//			FROM 
//			ABOUT
//			WHERE 
//			about_id = #{about_id}
//			""")
//	void deleteAboutBody(Integer about_id);


	@Update("""
			UPDATE 
			ABOUT
			SET
				   body = #{body}
			     , about_date = #{about_date}
			WHERE
			about_id = #{about_id}
			""")
	void insertAboutBody(Integer about_id);




}
