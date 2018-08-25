package net.jun.dblessboard.web.support.pagination;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.util.UriComponentsBuilder;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class PageLink {
	private int page;
	private String url;
	private boolean selected;

	static PageLink of(int page, String basePath, boolean selected) {
		final String url = buildUrl(page, basePath);
		return new PageLink(page, url, selected);
	}

	private static String buildUrl(int page, String basePath) {
		return UriComponentsBuilder.fromPath(basePath)
					.queryParam("page", page)
					.toUriString();
	}
}
