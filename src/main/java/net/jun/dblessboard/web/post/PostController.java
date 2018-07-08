package net.jun.dblessboard.web.post;

import net.jun.dblessboard.domain.post.Post;
import net.jun.dblessboard.service.post.PostDto;
import net.jun.dblessboard.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {

	private final PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping({"/", "/posts"})
	public String postList(Model model) {
		final List<Post> posts = postService.getAllPosts();
		model.addAttribute("posts", posts);
		return "post/list";
	}

	@GetMapping("/posts/write")
	public String postWrite() {
		return "post/write";
	}

	@PostMapping("/posts/new")
	public String createNewPost(PostDto postDto) {
		postService.createPost(postDto);
		return "redirect:/";
	}
}
