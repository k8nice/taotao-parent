package com.nice.rest.service.impl;

import com.nice.mapper.TbContentMapper;
import com.nice.pojo.TbContent;
import com.nice.pojo.TbContentExample;
import com.nice.pojo.TbContentExample.Criteria;
import com.nice.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 调用服务层服务，查询内容列表
 * @author ningh
 */
@Service
public class ContentServiceImpl  implements ContentService {

    @Autowired
    private TbContentMapper contentMapper;

    @Override
    public List<TbContent> getContentList(long contentCid) {
        //根据内容分类id查询内容列表
        TbContentExample example = new TbContentExample();
        Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(contentCid);
        //执行查询
        List<TbContent> list = contentMapper.selectByExample(example);
        return list;
    }
}
