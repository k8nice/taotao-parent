package com.nice.controller;

import com.nice.common.pojo.EUTreeNode;
import com.nice.common.utils.TaotaoResult;
import com.nice.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容分类管理
 * @author ningh
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EUTreeNode> getContentCatList(@RequestParam(value = "id" , defaultValue = "0") long parentId){
        List<EUTreeNode> list = contentCategoryService.getCategoryList(parentId);
        return  list;
    }

    @RequestMapping("/create")
    @ResponseBody
    public TaotaoResult createContentCategory(Long parentId,String name){
        TaotaoResult result = contentCategoryService.insertContentCategory(parentId, name);
        return result;
    }

}
