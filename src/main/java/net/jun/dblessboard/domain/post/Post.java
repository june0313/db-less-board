package net.jun.dblessboard.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Post {
	private Long id;
	private String title;
	private String contents;
	private String writer;
}
