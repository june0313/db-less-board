package net.jun.dblessboard.web.support.pagination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class PaginationTest {
	@Test
	public void testWhenCurrentPageIsStartPage() {
		final Pagination sut = Pagination.builder()
				.basePath("/post")
				.currentPage(1)
				.totalCount(9)
				.build();

		assertThat(sut.getLinks()).hasSize(1);
		assertThat(sut.getLinks().get(0).getPage()).isEqualTo(1);
		assertThat(sut.getLinks().get(0).getUrl()).isEqualTo("/post?page=1");
		assertThat(sut.getLinks().get(0).isSelected()).isTrue();
		assertThat(sut.getHasNextPage()).isFalse();
		assertThat(sut.getHasPreviousPage()).isFalse();
		assertThat(sut.getNextPageLink().getPage()).isEqualTo(2);
		assertThat(sut.getPreviousPageLink().getPage()).isEqualTo(0);
	}

	@Test
	public void testWhenCurrentPageIsEndPage() {
		final Pagination sut = Pagination.builder()
				.basePath("/post")
				.currentPage(5)
				.totalCount(51)
				.build();

		assertThat(sut.getLinks()).hasSize(5);
		assertThat(sut.getLinks().get(0).getPage()).isEqualTo(1);
		assertThat(sut.getLinks().get(0).getUrl()).isEqualTo("/post?page=1");
		assertThat(sut.getLinks().get(4).isSelected()).isTrue();
		assertThat(sut.getHasNextPage()).isTrue();
		assertThat(sut.getHasPreviousPage()).isFalse();
		assertThat(sut.getNextPageLink().getPage()).isEqualTo(6);
		assertThat(sut.getPreviousPageLink().getPage()).isEqualTo(0);
	}

	@Test
	public void testWhenCurrentPageIs2() {
		final Pagination sut = Pagination.builder()
				.basePath("/post")
				.currentPage(2)
				.totalCount(51)
				.build();

		assertThat(sut.getLinks()).hasSize(5);
		assertThat(sut.getLinks().get(0).getPage()).isEqualTo(1);
		assertThat(sut.getLinks().get(0).getUrl()).isEqualTo("/post?page=1");
		assertThat(sut.getLinks().get(1).isSelected()).isTrue();
		assertThat(sut.getLinks().get(4).getPage()).isEqualTo(5);
		assertThat(sut.getLinks().get(4).getUrl()).isEqualTo("/post?page=5");
		assertThat(sut.getHasNextPage()).isTrue();
		assertThat(sut.getHasPreviousPage()).isFalse();
		assertThat(sut.getNextPageLink().getPage()).isEqualTo(6);
		assertThat(sut.getPreviousPageLink().getPage()).isEqualTo(0);
	}

	@Test
	public void testWhenCurrentPageIs6() {
		final Pagination sut = Pagination.builder()
				.basePath("/post")
				.currentPage(6)
				.totalCount(51)
				.build();

		assertThat(sut.getLinks()).hasSize(1);
		assertThat(sut.getLinks().get(0).getPage()).isEqualTo(6);
		assertThat(sut.getLinks().get(0).getUrl()).isEqualTo("/post?page=6");
		assertThat(sut.getLinks().get(0).isSelected()).isTrue();
		assertThat(sut.getHasNextPage()).isFalse();
		assertThat(sut.getHasPreviousPage()).isTrue();
		assertThat(sut.getNextPageLink().getPage()).isEqualTo(7);
		assertThat(sut.getPreviousPageLink().getPage()).isEqualTo(5);
	}
}