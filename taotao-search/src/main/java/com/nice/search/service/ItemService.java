package com.nice.search.service;

import com.nice.common.utils.TaotaoResult;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**
 * @author ningh
 */
public interface ItemService {

    TaotaoResult importAllItems() throws IOException, SolrServerException;

}
