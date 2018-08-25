package net.jun.dblessboard.service.post;

import lombok.Builder;
import lombok.Getter;
import net.jun.dblessboard.domain.post.Post;

import java.util.List;

@Getter
@Builder
public class PostListDto {
	private List<Post> posts;
	private int totalCount;
}
