package com.nice.service;

import com.nice.common.pojo.EUTreeNode;

import java.util.List;

/**
 * @author ningh
 */
public interface ItemCatService {

    /**
     * @param parentId
     * @return
     */
    List<EUTreeNode> getCatList(long parentId);
}
