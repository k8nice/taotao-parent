package com.nice.test;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;

/**
 * @author ningh
 */
public class SolrJTest {

    @Test
    public void addDocument(){
        //创建一连接
        SolrServer solrServer = new HttpSolrServer("http://192.168.174.144:8080/solr");
        //创建一个文档对象
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id","test001");
        document.addField("item_title","nice");
        document.addField("item_price",654321);
        //把文档写入索引库
        try {
            solrServer.add(document);
            solrServer.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteDocument() throws IOException, SolrServerException {
        //创建一连接
        SolrServer solrServer = new HttpSolrServer("http://192.168.174.144:8080/solr");
//        solrServer.deleteById("test001");
        solrServer.deleteByQuery("*:*");
        solrServer.commit();
    }

}
