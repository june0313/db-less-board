package net.jun.dblessboard.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.jun.dblessboard.repository.Pageable;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DefaultPageable implements Pageable {
	private static final int DEFAULT_SIZE = 10;

	private int page;
	private int startIndex;
	private int size;

	public static DefaultPageable of(int page) {
		return new DefaultPageable(page, (page - 1) * DEFAULT_SIZE, DEFAULT_SIZE);
	}

	@Override
	public int page() {
		return page;
	}

	@Override
	public int startIndex() {
		return startIndex;
	}

	@Override
	public int size() {
		return size;
	}
}
