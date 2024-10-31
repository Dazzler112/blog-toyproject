package com.toyblog.blog_toyproject.mapper;

import org.apache.ibatis.annotations.*;

import com.toyblog.blog_toyproject.dto.*;

@Mapper
public interface BlogMemberMapper {

	@Insert("""
			INSERT 
			INTO
			MEMBERS
				   (
				      member_id
					, password
					, name
					, phone_number
					, email
					, member_type
				    )
			VALUES   
				   (
				      #{member_id}
				    , #{password}
				    , #{name}
				    , #{phone_number}
				    , #{email}
				    , #{member_type}
				   )
			""")
	Integer SignUp(Members member);
	
	@Insert("""
			INSERT 
			INTO
			MEMBERAUTHORITY
			VALUES
				  (
				    #{member_id}
				  , #{authority}  
				  )
			""")
	void insertAuthority(Members member);
	
	@Select("""
			SELECT
			*
			FROM
			MEMBERS m
			LEFT JOIN 
			MEMBERAUTHORITY ma
			ON
			m.member_id = ma.member_id
			WHERE member_id = #{member_id}
			""")
//	@ResultMap("memberResult")
	Members slectById(String member_id);

	@Select("""
			SELECT 
			*
			FROM
			MEMBERS
			WHERE 
			member_id = #{member_id}
			""")
//	@ResultMap("memberResult")
	Members selectByMemberId(String member_id);


}
