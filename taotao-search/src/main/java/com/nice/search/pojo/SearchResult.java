package com.nice.search.pojo;

import java.util.List;

/**
 * @author ningh
 */
public class SearchResult {

    /**
     * 商品列表
     */
    private List<Item> itemList;

    /**
     * 总记录数
     */
    private Long recordCount;

    /**
     * 总页数
     */
    private Long pageCount;

    /**
     * 当前页
     */
    private Long curPage;

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Long recordCount) {
        this.recordCount = recordCount;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public Long getCurPage() {
        return curPage;
    }

    public void setCurPage(Long curPage) {
        this.curPage = curPage;
    }
}
