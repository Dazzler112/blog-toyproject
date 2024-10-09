package com.toyblog.blog_toyproject.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.dto.*;

@Mapper
public interface BlogBoardMapper {

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
			WHRER board_id = #{board_id}
		
			""")
	List<About> findByMembeId(String member_id, Integer board_id);

}
