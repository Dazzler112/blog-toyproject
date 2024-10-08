package com.toyblog.blog_toyproject.mapper;

import org.apache.ibatis.annotations.*;

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
	About addAboutBody(About about);

}
