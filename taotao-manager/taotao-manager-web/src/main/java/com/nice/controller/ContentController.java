package com.nice.controller;

import com.nice.common.utils.TaotaoResult;
import com.nice.pojo.TbContent;
import com.nice.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容管理Controller
 * @author ningh
 */
@Controller
@RequestMapping("/content")
public class ContentController {

  @Autowired
  private ContentService contentService;

  @RequestMapping("/save")
  @ResponseBody
  public TaotaoResult insertContent(TbContent content){
      TaotaoResult result = contentService.insertContent(content);
      return result;
  }

}
