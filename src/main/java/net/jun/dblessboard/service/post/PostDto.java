package net.jun.dblessboard.service.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
	private Long id;
	private String title;
	private String contents;
	private String writer;
}
