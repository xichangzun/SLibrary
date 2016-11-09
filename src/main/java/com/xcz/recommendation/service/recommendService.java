package com.xcz.recommendation.service;

import com.xcz.recommendation.domain.Recommendation;

import java.util.ArrayList;

/**
 * Created by root on 16-10-15.
 */
public interface recommendService  {
    Boolean addrecommend(Recommendation a);
    int getPageCount(int pagesize, String type);
    ArrayList<Recommendation> get(int page, int pagesize, String type);
    Boolean handleRecom(String id, String isbn, String state);
}
