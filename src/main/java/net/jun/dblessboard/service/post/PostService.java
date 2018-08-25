package net.jun.dblessboard.service.post;

import net.jun.dblessboard.domain.post.Post;
import net.jun.dblessboard.repository.Page;
import net.jun.dblessboard.repository.post.PostRepository;
import net.jun.dblessboard.service.DefaultPageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	private final PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public PostListDto getAllPosts(int page) {
		Page<Post> postPage = postRepository.findAll(DefaultPageable.of(page));

		return PostListDto.builder()
				.posts(postPage.getElements())
				.totalCount(postPage.getTotalCount())
				.build();
	}

	public void createPost(PostDto postDto) {
		Post post = Post.builder()
				.title(postDto.getTitle())
				.contents(postDto.getContents())
				.writer(postDto.getWriter())
				.build();

		postRepository.save(post);
	}

	public PostDto getPost(Long id) {
		Post post = postRepository.findOne(id);

		return PostDto.builder()
				.id(post.getId())
				.contents(post.getContents())
				.title(post.getTitle())
				.writer(post.getWriter())
				.build();
	}
}
