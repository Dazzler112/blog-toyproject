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

	// search 추가해야 해서 주석처리
//	@Select("""
//			SELECT
//				b.board_id
//			  , b.title
//			  , b.body
//			  , b.writer
//			  , b.write_date
//			  , b.category
//			  , b.views
//			  , p.photo_name
//			  ,
//			  (
//			   SELECT 
//			   	COUNT(*)
//			   FROM
//			   BOARDLIKE
//			   WHERE 	
//			   	board_id = b.board_id
//			  )	like_count
//			  ,
//			  (
//			   SELECT 
//			   	COUNT(*)
//			   FROM
//			   BOARDREPLY
//			   WHERE 	
//			   	board_id = b.board_id
//			  )	reply_count
//			FROM
//			   BOARD b
//			   LEFT JOIN
//			   PHOTO p 
//			   ON
//			   b.board_id = p.board_id
//			   ORDER BY board_id DESC
//			""")
//	@ResultMap("boardPageMap")
//	List<Board> selectBoard();
	
	@Select("""
			<script>
			<bind name="pattern" value="'%' + search + '%'" />
			SELECT
				b.board_id
			  , b.title
			  , b.body
			  , b.writer
			  , b.write_date
			  , b.category
			  , b.views
			  , p.photo_name
			  ,
			  (
			   SELECT 
			   	COUNT(*)
			   FROM
			   BOARDLIKE
			   WHERE 	
			   	board_id = b.board_id
			  )	like_count
			  ,
			  (
			   SELECT 
			   	COUNT(*)
			   FROM
			   BOARDREPLY
			   WHERE 	
			   	board_id = b.board_id
			  )	reply_count
			FROM
			   BOARD b
			   LEFT JOIN
			   PHOTO p 
			   ON
			   b.board_id = p.board_id
			   
			<where>
				<if test="(type eq 'all') or (type eq 'title')">
				   b.title  LIKE #{pattern}
				</if>
			</where>			
			   GROUP BY b.board_id
			   ORDER BY board_id DESC
			</script>
			""")
	@ResultMap("boardPageMap")
	List<Board> selectAllMainBoard(String search, String type);

	@Select("""
			<script>
			<bind name="pattern" value="'%' + search + '%'" />
			SELECT COUNT(*) 
			FROM BOARD
			
			<where>
				<if test="(type eq 'all') or (type eq 'title')">
				   title  LIKE #{pattern}
				</if>
			</where>
			
			</script>			
			""")
	Integer countAll(String search, String type);
	
	@Select("""
			SELECT
				b.board_id
			  , b.title
			  , b.body
			  , b.writer
			  , b.write_date
			  , b.category
			  , b.views
			  , p.photo_name
			  ,			  
			  (
			   SELECT 
			   	COUNT(*)
			   FROM
			   BOARDLIKE
			   WHERE 	
			   	board_id = b.board_id
			  )	like_count
			  ,
			  (
			   SELECT 
			   	COUNT(*)
			   FROM
			   BOARDREPLY
			   WHERE 	
			   	board_id = b.board_id
			  )	reply_count			  
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
	Board selectPostBoardId(Integer board_id);
	
	@Select("""
			SELECT 
			photo_name
			FROM
			PHOTO
			WHERE board_id = #{board_id}
			""")
	List<String> selectPhotoFile(Integer board_id);

	@Delete("""
			DELETE
			FROM
			PHOTO
			WHERE
			board_id = #{board_id}
			""")
	void deletePhotoBoardId(Integer board_id);

	@Delete("""
			DELETE
			FROM
			BOARD
			WHERE
			board_id = #{board_id}
			""")
	int deletePost(Integer board_id);

	@Delete("""
			DELETE
			FROM
			PHOTO
			WHERE
			board_id = #{board_id}
			AND
			photo_name = #{photo_name}
			""")
	void deletePhotoName(Integer board_id, String photo_name);

	@Insert("""
			INSERT
			INTO
			PHOTO
			     (
				  board_id
				, photo_name
				 )
			VALUES
				  (
				   #{board_id}
				 , #{photo_name}
				  )
			""")
	void updatePhotoName(Integer board_id, String photo_name);

	@Update("""
			UPDATE
			BOARD
			SET
				title = #{title}
			  ,	body = #{body}
			  , write_date = #{write_date}
			  , category = #{category}
			WHERE
			  board_id = #{board_id}
			""")
	int updateBoard(Board board);
	
	@Update("""
			UPDATE
			BOARD
			SET
				views = views + 1
			WHERE
				board_id = #{board_id}
			""")
	Integer blogPostingViews(Integer board_id);

	@Select("""
			SELECT
				b.board_id
			  , b.title
			  , b.views
			  , p.photo_name
			  ,
			  (
			   SELECT 
			   	COUNT(*)
			   FROM
			   BOARDLIKE
			   WHERE 	
			   	board_id = b.board_id
			  )	like_count
			  ,
			  (
			   SELECT 
			   	COUNT(*)
			   FROM
			   BOARDREPLY
			   WHERE 	
			   	board_id = b.board_id
			  )	reply_count	
			FROM
			   BOARD b
			   LEFT JOIN
			   PHOTO p 
			   ON
			   b.board_id = p.board_id
			   WHERE
			   b.board_id < #{board_id}
			   ORDER BY board_id DESC LIMIT 1			  		  	
			""")
	@ResultMap("boardTotalMap")
	Board getPreviousPost(Integer board_id);

	@Select("""
			SELECT
				b.board_id
			  , b.title
			  , b.views
			  , p.photo_name
			  ,
			  (
			   SELECT 
			   	COUNT(*)
			   FROM
			   BOARDLIKE
			   WHERE 	
			   	board_id = b.board_id
			  )	like_count
			  ,
			  (
			   SELECT 
			   	COUNT(*)
			   FROM
			   BOARDREPLY
			   WHERE 	
			   	board_id = b.board_id
			  )	reply_count	
			FROM
			   BOARD b
			   LEFT JOIN
			   PHOTO p 
			   ON
			   b.board_id = p.board_id
			   WHERE
			   b.board_id > #{board_id}
			   ORDER BY board_id ASC LIMIT 1			  		  	
			""")	
	@ResultMap("boardTotalMap")	
	Board getNextPost(Integer board_id);

	@Select("""
			SELECT
				b.board_id
			  , b.title
			  , b.views
			  , p.photo_name
			  ,
			  (
			   SELECT 
			   	COUNT(*)
			   FROM
			   BOARDLIKE
			   WHERE 	
			   	board_id = b.board_id
			  )	like_count
			  ,
			  (
			   SELECT 
			   	COUNT(*)
			   FROM
			   BOARDREPLY
			   WHERE 	
			   	board_id = b.board_id
			  )	reply_count	
			FROM
			   BOARD b
			   LEFT JOIN
			   PHOTO p 
			   ON
			   b.board_id = p.board_id
			   WHERE
			   b.board_id < #{board_id}
			   ORDER BY board_id DESC LIMIT #{limit}			  		  	
			""")		
	@ResultMap("boardTotalMap")	
	List<Board> getPreviousPostExtra(Integer board_id, int limit);

	
}
