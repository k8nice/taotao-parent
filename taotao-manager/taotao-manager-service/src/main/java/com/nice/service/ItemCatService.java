package com.nice.service;

import com.nice.common.pojo.EUTreeNode;

import java.util.List;

public interface ItemCatService {

    List<EUTreeNode> getCatList(long parentId);
}
