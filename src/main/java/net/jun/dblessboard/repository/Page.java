package net.jun.dblessboard.repository;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Page<T> {
	private int totalCount;
	private int currentPage;
	private List<T> elements;

	public static <T> Page<T> of(int totalCount, int currentPage, List<T> elements) {
		return new Page<>(totalCount, currentPage, elements);
	}
}
