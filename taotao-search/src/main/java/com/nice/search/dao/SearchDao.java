package com.nice.search.dao;

import com.nice.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;

/**
 * @author ningh
 */
public interface SearchDao {

    public SearchResult search(SolrQuery query) throws SolrServerException;

}
