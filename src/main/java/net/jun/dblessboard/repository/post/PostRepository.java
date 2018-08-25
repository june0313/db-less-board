package net.jun.dblessboard.repository.post;

import com.google.common.collect.Maps;
import net.jun.dblessboard.domain.post.Post;
import net.jun.dblessboard.repository.Page;
import net.jun.dblessboard.repository.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class PostRepository {

	private Map<Long, Post> postMap;

	@PostConstruct
	public void init() {
		postMap = Maps.newHashMap();
		IntStream.range(0, 65).forEach(i -> this.save(Post.builder().title("Lorem" + i).contents("Lorem ipsum dolor sit amet").writer("Ipsum").build()));
	}

	public Page<Post> findAll(Pageable pageable) {
		final List<Post> postList = postMap.values().stream()
				.skip(pageable.startIndex())
				.limit(pageable.size())
				.collect(Collectors.toList());

		return Page.of(postMap.size(), pageable.page(), postList);
	}

	public Post findOne(Long id) {
		return postMap.get(id);
	}

	public void save(Post post) {
		final Long nextId = findNextId();
		post.setId(nextId);
		postMap.put(nextId, post);
	}

	private Long findNextId() {
		if (postMap.isEmpty()) {
			return 1L;
		}

		long maxId = postMap.keySet().stream().mapToLong(key -> key).max().orElse(0L);
		return maxId + 1;
	}
}
