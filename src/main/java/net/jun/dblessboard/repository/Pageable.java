package net.jun.dblessboard.repository;

public interface Pageable {
	int page();
	int startIndex();
	int size();
}
