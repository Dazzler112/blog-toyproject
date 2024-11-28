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
			WHERE 
			m.member_id = #{member_id}
			""")
	@ResultMap("memberMap")
	Members selectByMemberId(String member_id);

	@Select("""
			SELECT
			*
			FROM
			MEMBERS
			WHERE 
			phone_number = #{phone_number}
			""")
//	@ResultMap("simpleMemberMap")
	Members selectByPhoneNumber(String phone_number);

	@Select("""
			SELECT
			*
			FROM
			MEMBERS
			WHERE
			email = #{email}
			""")
	Members selectByCheckEmailId(String email);

	@Update("""
			<script>
			UPDATE 
			MEMBERS
			SET
				<if test="password neq null and password neq ''">
				password = #{password}
				</if>
			WHERE
				member_id = #{member_id}
			</script>
			""")
	Integer memberUpdate(Members member);

	@Delete("""
			DELETE 
			FROM
			MEMBERS
			WHERE 
			member_id = #{member_id}
			""")
	Integer deleteMemberId(String member_id);

}
