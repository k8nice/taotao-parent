package com.nice.controller;

import com.nice.common.pojo.EUDataGridResult;
import com.nice.common.utils.TaotaoResult;
import com.nice.pojo.TbItem;
import com.nice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ningh
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        TbItem tbItem = itemService.getItemById(itemId);
        return tbItem;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page,Integer rows){
        EUDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }


    @RequestMapping(value = "/item/save",method = RequestMethod.POST)
    @ResponseBody
    private TaotaoResult createItem(TbItem item,String desc,String itemParams){
        TaotaoResult result = null;
        try {
            result = itemService.createItem(item,desc,itemParams);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return result;
        }
    }

}
