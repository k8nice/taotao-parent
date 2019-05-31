package com.nice.service;

import com.nice.common.pojo.EUTreeNode;
import com.nice.common.utils.TaotaoResult;

import java.util.List;

public interface ContentCategoryService {

    List<EUTreeNode> getCategoryList(long parentId);

    TaotaoResult insertContentCategory(long parentId,String name);

}
