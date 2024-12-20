package com.toyblog.blog_toyproject.mapper;

import java.util.*;

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

	@Select("""
			SELECT
				b.board_id
			  , b.title
			  , b.body
			  , b.writer
			  , b.write_date
			  , b.category
			  , p.photo_name
			FROM
			   BOARD b
			   LEFT JOIN
			   PHOTO p 
			   ON
			   b.board_id = p.board_id
			""")
	@ResultMap("boardTotalMap")
	List<Board> selectBoard();

	@Select("""
			SELECT
				b.board_id
			  , b.title
			  , b.body
			  , b.writer
			  , b.write_date
			  , b.category
			  , p.photo_name
			FROM
			   BOARD b
			   LEFT JOIN
			   PHOTO p 
			   ON
			   b.board_id = p.board_id
			   WHERE
			   b.board_id = #{board_id}
			""")
	@ResultMap("boardTotalMap")
	List<Board> selectPostBoardId(Integer board_id);

}
