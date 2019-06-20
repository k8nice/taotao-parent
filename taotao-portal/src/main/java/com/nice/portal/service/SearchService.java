package com.nice.portal.service;

import com.nice.portal.pojo.SearchResult;

/**
 * @author ningh
 */
public interface SearchService {

    SearchResult search(String queryString,int page);

}
