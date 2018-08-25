package net.jun.dblessboard.web.support.pagination;

import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Builder
public class Pagination {
	private static final int DEFAULT_PAGE_COUNT = 5;
	private static final int DEFAULT_ELEMENT_COUNT_PER_PAGE = 10;

	private int totalCount;
	private int currentPage;
	private String basePath;

	public List<PageLink> getLinks() {
		return IntStream.rangeClosed(getStartPage(), getEndPage())
				.mapToObj(page -> PageLink.of(page, basePath, page == currentPage))
				.collect(Collectors.toList());
	}

	public boolean getHasPreviousPage() {
		return getStartPage() > 1;
	}

	public boolean getHasNextPage() {
		return getEndPage() < getMaxPage();
	}

	public PageLink getPreviousPageLink() {
		return PageLink.of(getStartPage() - 1, basePath, false);
	}

	public PageLink getNextPageLink() {
		return PageLink.of(getEndPage() + 1, basePath, false);
	}

	private int getStartPage() {
		final int pageBundleIndex = ((currentPage - 1) / DEFAULT_PAGE_COUNT);
		return DEFAULT_PAGE_COUNT * pageBundleIndex + 1;
	}

	private int getEndPage() {
		final int endPage = getStartPage() + DEFAULT_PAGE_COUNT - 1;
		final int maxPage = getMaxPage();
		return Integer.min(endPage, maxPage);
	}

	private int getMaxPage() {
		final int pageCount = totalCount / DEFAULT_ELEMENT_COUNT_PER_PAGE;
		return (totalCount % DEFAULT_ELEMENT_COUNT_PER_PAGE) == 0 ? pageCount : pageCount + 1;
	}
}
