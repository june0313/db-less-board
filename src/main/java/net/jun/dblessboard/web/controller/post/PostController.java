package net.jun.dblessboard.web.controller.post;

import net.jun.dblessboard.service.post.PostDto;
import net.jun.dblessboard.service.post.PostListDto;
import net.jun.dblessboard.service.post.PostService;
import net.jun.dblessboard.web.support.pagination.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

	private final PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping({"/", "/posts"})
	public String postList(@RequestParam(defaultValue = "1") int page, Model model) {
		final PostListDto postListDto = postService.getAllPosts(page);
		final Pagination pagination = Pagination.builder()
				.basePath("/posts")
				.currentPage(page)
				.totalCount(postListDto.getTotalCount())
				.build();

		model.addAttribute("posts", postListDto.getPosts());
		model.addAttribute("pagination", pagination);
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

	@GetMapping("/posts/{id}/detail")
	public String postDetail(@PathVariable("id") Long id, Model model) {
		final PostDto postDto = postService.getPost(id);
		model.addAttribute("post", postDto);
		return "post/detail";
	}
}
