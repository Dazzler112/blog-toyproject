package com.toyblog.blog_toyproject.mapper;

import org.apache.ibatis.annotations.*;

import com.toyblog.blog_toyproject.dto.*;

@Mapper
public interface BlogMemberManageMapper {

	@Update("""
			UPDATE
			MEMBERS
			SET
			 member_type = #{member_type}
			WHERE
			 member_id = #{member_id}
			""")
	Integer setUserBlock(Members members);

	@Update("""
			UPDATE
			MEMBERS
			SET
			 member_type = #{member_type}
			WHERE
			 member_id = #{member_id}			
			""")
	Integer setUserRemove(Members member);

}
