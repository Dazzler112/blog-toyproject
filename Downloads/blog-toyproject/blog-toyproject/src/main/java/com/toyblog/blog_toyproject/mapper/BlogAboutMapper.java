package com.toyblog.blog_toyproject.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.dto.*;

@Mapper
public interface BlogAboutMapper {

	@GetMapping("""
			SELECT
				  about_id
				, title
				, member_id
				, writer
				, body
				, about_date
			FROM
				ABOUT
			WHERE
				member_id = #{member_id}			
			""")
	About findByMemberId(String member_id);
	
	
//	@GetMapping("""
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
//				about_id = #{about_id}
//			""")
//	About findByAboutId(Integer about_id);
	
	@GetMapping("""
			SELECT
				  about_id
				, title
				, member_id
				, writer
				, body
				, about_date
			FROM
				ABOUT
			WHERE
				about_id = #{about_id}
			""")
	List<About> findByAboutId(Integer about_id);
	
	@Insert("""
			INSERT INTO 
			ABOUT
				(
				  about_id
				, title
				, member_id
				, writer
				, body
				, about_date
				)
			VALUES
				(
				    #{about_id}
				  , #{title}
				  , #{member_id}
				  , #{writer}
				  , #{body}
				  , #{about_date}
				 )
			""")
	int addAboutBody(About about);




}
