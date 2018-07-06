package net.jun.dblessboard.repository.post;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.jun.dblessboard.domain.post.Post;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Component
public class PostRepository {

	private Map<Long, Post> postMap;

	@PostConstruct
	public void init() {
		postMap = Maps.newHashMap();
		postMap.put(1L, Post.builder().id(1L).title("나윤권").contents("기대").writer("user").build());
		postMap.put(2L, Post.builder().id(2L).title("토이").contents("여전히").writer("june").build());
		postMap.put(3L, Post.builder().id(3L).title("피구왕").contents("통키").writer("tongki").build());
	}

	public List<Post> findAll() {
		return Lists.newArrayList(postMap.values());
	}
}
