package com.portfolio.springboot.caching;

public interface BookRepository {

    Book getByIsbn(String isbn);

}
