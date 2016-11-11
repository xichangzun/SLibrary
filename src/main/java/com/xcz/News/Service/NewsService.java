package com.xcz.News.Service;

import com.xcz.News.domain.News;

/**
 * Created by root on 16-11-4.
 */
public interface NewsService {
    Boolean addNews(News a);
    Boolean updateNews(News a);
    News[] query();
    News[] res_query();
}
