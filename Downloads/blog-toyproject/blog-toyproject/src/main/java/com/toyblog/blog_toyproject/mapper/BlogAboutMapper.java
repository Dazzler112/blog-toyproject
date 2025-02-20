package com.toyblog.blog_toyproject.mapper;

import java.util.*;

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
	@Delete("""
			DELETE 
			FROM 
			ABOUT
			WHERE 
			about_id = #{about_id}
			""")
	void deleteAboutBody(Integer about_id);

	@Update("""
			UPDATE 
			ABOUT
			SET
				   body = #{body}
			WHERE
			member_id = #{member_id}
			AND
			about_id = #{about_id}
			""")
	void insertAboutBody(About about);

	@Insert("""
				INSERT 
				INTO
				ABOUTIMG(member_id)
				VALUES(#{member_id})
			""")
	@Options(useGeneratedKeys = true, keyProperty = "aphoto_id", keyColumn = "aphoto_id")
	Integer insertPhoto(AboutImg aboutImg);

	@Insert("""
				INSERT 
				INTO
				ABOUTPHOTO(aphoto_id, photo_name)
				VALUES(#{aphoto_id}, #{photo_name})			
			""")
	Integer insertFileName(Integer aphoto_id, String photo_name);

	
	@Select("""
			SELECT
			  a.aphoto_id
			, b.photo_name 
			FROM
			ABOUTIMG a
			LEFT JOIN
			ABOUTPHOTO b
			ON
			a.aphoto_id = b.aphoto_id
			""")
	@ResultMap("aboutImgMap")
	List<AboutImg> getAboutImgPost();

	@Delete("""
			DELETE
			FROM
			ABOUTPHOTO
			WHERE
			aphoto_id = #{aphoto_id}
			AND
			photo_name = #{photo_name}
			""")
	Integer deleteAboutPhotoName(Integer aphoto_id, String photo_name);

	@Insert("""
			INSERT
			INTO
			ABOUTPHOTO
				  (
				     aphoto_id
				   , photo_name
				  )
			VALUES
				  (
				    #{aphoto_id}
				  , #{photo_name}
				  )
			""")
	Integer updateAboutPhotoName(Integer aphoto_id, String photo_name);

	@Select("""
			SELECT
			  a.aphoto_id
			, a.member_id
			, b.photo_name 
			FROM
			ABOUTIMG a
			LEFT JOIN
			ABOUTPHOTO b
			ON
			a.aphoto_id = b.aphoto_id
			""")
	@ResultMap("aboutImgMap")
	AboutImg selectImgInfo(Integer aphoto_id);

}
