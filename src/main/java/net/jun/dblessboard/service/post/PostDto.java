package net.jun.dblessboard.service.post;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
	private Long id;
	private String title;
	private String contents;
	private String writer;
}
