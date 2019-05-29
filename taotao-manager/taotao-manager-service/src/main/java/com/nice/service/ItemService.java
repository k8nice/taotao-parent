package com.nice.service;

import com.nice.common.pojo.EUDataGridResult;
import com.nice.common.utils.TaotaoResult;
import com.nice.pojo.TbItem;

/**
 * @author ningh
 */
public interface ItemService {

    /**
     * @param itemId
     * @return
     */
    TbItem getItemById(long itemId);

    /**
     * @param page
     * @param rows
     * @return
     */
    EUDataGridResult getItemList(int page,int rows);

    /**
     * @param item
     * @return
     */
    TaotaoResult createItem(TbItem item,String desc,String itemParam) throws Exception;


}
