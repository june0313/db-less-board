package net.jun.dblessboard.service.post;

import net.jun.dblessboard.domain.post.Post;
import net.jun.dblessboard.repository.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

	private final PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	public void createPost(PostDto postDto) {
		Post post = Post.builder()
				.title(postDto.getTitle())
				.contents(postDto.getContents())
				.writer(postDto.getWriter())
				.build();

		postRepository.save(post);
	}
}
