package com.toyblog.blog_toyproject.mapper;

import org.apache.ibatis.annotations.*;

import com.toyblog.blog_toyproject.dto.*;

@Mapper
public interface BlogMailMapper {

	
	@Select("""
			SELECT
			*
			FROM
			MEMBERS
			WHERE
			email = #{email}
			""")
	Members selectByCheckEmailId(String email);
}
