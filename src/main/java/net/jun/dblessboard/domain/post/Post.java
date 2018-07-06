package net.jun.dblessboard.domain.post;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Post {
	private Long id;
	private String title;
	private String contents;
	private String writer;
}
