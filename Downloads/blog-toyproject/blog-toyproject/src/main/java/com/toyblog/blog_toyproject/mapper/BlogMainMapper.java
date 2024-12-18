package com.toyblog.blog_toyproject.mapper;

import org.apache.ibatis.annotations.*;

import com.toyblog.blog_toyproject.dto.*;

@Mapper
public interface BlogMainMapper {

	@Insert("""
			INSERT INTO 
			BOARD(title, body, writer, write_date, category)
			VALUES(#{title}, #{body}, #{writer}, #{write_date}, #{category})
			""")
	@Options(useGeneratedKeys = true, keyProperty = "board_id")
	Integer insertBoard(Board board);

	@Insert("""
			INSERT INTO
			PHOTO(board_id, photo_name)
			VALUES(#{board_id}, #{photo_name})
			""")
	Integer insertFileName(Integer board_id, String photo_name);

}
