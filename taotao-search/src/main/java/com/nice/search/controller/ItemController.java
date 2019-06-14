package com.nice.search.controller;

import com.nice.common.utils.TaotaoResult;
import com.nice.search.service.ItemService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * 索引库维护
 * @author ningh
 */
@Controller
@RequestMapping("/manager")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 导入商品数据到索引库
     */
    @RequestMapping("/importall")
    @ResponseBody
    public TaotaoResult importAllItems(){
        try {
            return itemService.importAllItems();
        } catch (IOException |SolrServerException e) {
            e.printStackTrace();
            return null;
        }
    }

}
