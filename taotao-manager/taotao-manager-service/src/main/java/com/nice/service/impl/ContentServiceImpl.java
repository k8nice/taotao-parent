package com.nice.service.impl;

import com.nice.common.utils.TaotaoResult;
import com.nice.mapper.TbContentMapper;
import com.nice.pojo.TbContent;
import com.nice.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 内容管理
 * @author ningh
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper contentMapper;

    @Override
    public TaotaoResult insertContent(TbContent content) {
        //补全pojo内容
        content.setCreated(new Date());
        content.setUpdated(new Date());
        contentMapper.insert(content);
        return TaotaoResult.ok();
    }
}
