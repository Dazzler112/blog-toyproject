package com.toyblog.blog_toyproject.api;

import java.io.*;
import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.format.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.service.*;

@RestController
public class BlogMainResource {

	@Autowired
	private BlogMainService blogMainService;
	
	@GetMapping("/post/{board_id}")
	public ResponseEntity<List<Board>> getPostBoard(@PathVariable Integer board_id) {
		
		List<Board> board = blogMainService.getPostBoardId(board_id);
		
		return ResponseEntity.ok(board);
	}

	@PostMapping(value = "/post/addpost", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void addMain(@RequestPart("photoFile") MultipartFile[] files, 
						@RequestParam("title") String title,
				        @RequestParam("body") String body,
				        @RequestParam("category") String category, 
				        @RequestParam("write_date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime writeDateStr,
				        Authentication authentication) throws IOException {
		
		// UTC 기준 시간 문자열을 Asia/Seoul 시간대로 변환
		ZonedDateTime seoulDateTime = ZonedDateTime.parse(writeDateStr + "+09:00")
				.withZoneSameInstant(ZoneId.of("Asia/Seoul"));
		LocalDateTime write_date = seoulDateTime.toLocalDateTime();
		
		Board board = new Board();
		board.setTitle(title);
		board.setBody(body);
		board.setCategory(category);
		board.setWrite_date(write_date);
		board.setWriter(authentication.getName());
		
		boolean add = blogMainService.addboard(board, files);
		
		if(!add) {
			throw new RuntimeException("게시글 등록 실패");
		}
	}
}
