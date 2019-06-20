package com.nice.portal.controller;

import com.nice.pojo.TbItem;
import com.nice.portal.pojo.Item;
import com.nice.portal.pojo.ItemInfo;
import com.nice.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Type;

/**
 * 商品详情页面展示
 * @author ningh
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * @param itemId
     * @param model
     * @return
     */
    @RequestMapping("/item/{itemId}")
    public String showItem(@PathVariable Long itemId ,Model model){
        ItemInfo item = itemService.getItemById(itemId);
        model.addAttribute("item",item);
        return "item";
    }


    @RequestMapping(value = "/item/desc/{itemId}" , produces = MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
    @ResponseBody
    public String getItemDesc(@PathVariable Long itemId){
        String string = itemService.getItemDescById(itemId);
        return string;
    }

    @RequestMapping(value = "/item/param/{itemId}" , produces = MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
    @ResponseBody
    public String getItemParam(@PathVariable Long itemId){
        String string = itemService.getItemParam(itemId);
        return string;
    }
}
