package com.nice.service;

import com.nice.common.pojo.EUDataGridResult;
import com.nice.pojo.TbItem;

/**
 * @author ningh
 */
public interface ItemService {

    TbItem getItemById(long itemId);

    EUDataGridResult getItemList(int page,int rows);

}
