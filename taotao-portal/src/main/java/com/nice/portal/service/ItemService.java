package com.nice.portal.service;

import com.nice.pojo.TbItem;
import com.nice.portal.pojo.Item;
import com.nice.portal.pojo.ItemInfo;

/**
 * @author ningh
 */
public interface ItemService {

    ItemInfo getItemById(Long itemId);

    String getItemDescById(Long itemId);

    String getItemParam(Long itemId);

}
