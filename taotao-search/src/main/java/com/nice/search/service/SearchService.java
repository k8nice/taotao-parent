package com.nice.search.service;

import com.nice.search.pojo.SearchResult;

/**
 * @author ningh
 */
public interface SearchService {

    public SearchResult search(String queryString,int page,int rows);

}
