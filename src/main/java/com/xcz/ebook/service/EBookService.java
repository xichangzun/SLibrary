package com.xcz.ebook.service;

import com.xcz.ebook.domain.EBook;

import java.util.ArrayList;

/**
 * Created by yhq on 2016/11/6.
 */
public interface EBookService {
    ArrayList<EBook> search(String type, String keyword);
}
