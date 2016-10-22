package com.xcz.search.service;

import com.xcz.search.domain.Book;

/**
 * Created by root on 16-10-8.
 */
public interface SearchService {
    Book[] search(String keyword, String type);

}
