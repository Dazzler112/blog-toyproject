package com.toyblog.blog_toyproject.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.dto.*;

@Mapper
public interface BlogBoardMapper {

	@GetMapping("""
			SELECT
			*
			FROM
			ABOUT
			WHERE
			about_id = #{about_id}
			""")
	List<About> findByMemberId(Integer about_id);
	
	
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
