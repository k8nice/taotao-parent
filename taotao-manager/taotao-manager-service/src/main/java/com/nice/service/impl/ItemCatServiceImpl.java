package com.nice.service.impl;

import com.nice.common.pojo.EUTreeNode;
import com.nice.mapper.TbItemCatMapper;
import com.nice.mapper.TbItemMapper;
import com.nice.pojo.TbItemCat;
import com.nice.pojo.TbItemCatExample;
import com.nice.pojo.TbItemCatExample.Criteria;
import com.nice.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类管理
 * @author ningh
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Override
    public List<EUTreeNode> getCatList(long parentId) {
        //创建查询条件
        TbItemCatExample example = new TbItemCatExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //根据条件查询
        List<EUTreeNode> resultList = new ArrayList<>();
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        //把列表转换成treeNodeList
        for (TbItemCat tbItemCat : list) {
            EUTreeNode node = new EUTreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            resultList.add(node);
        }
        //返回结果
        return resultList;
    }
}
