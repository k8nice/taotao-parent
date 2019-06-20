package com.nice.portal.service.impl;

import com.nice.common.utils.HttpClientUtil;
import com.nice.common.utils.JsonUtils;
import com.nice.common.utils.TaotaoResult;
import com.nice.pojo.TbItem;
import com.nice.pojo.TbItemDesc;
import com.nice.pojo.TbItemParamItem;
import com.nice.portal.pojo.Item;
import com.nice.portal.pojo.ItemInfo;
import com.nice.portal.service.ItemService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 商品信息管理Service
 * @author ningh
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${ITEM_INFO_URL}")
    private String ITEM_INFO_URL;
    @Value("${ITEM_DESC_URL}")
    private String ITEM_DESC_URL;
    @Value("${ITEM_PARAM_URL}")
    private String ITEM_PARAM_URL;

    @Override
    public ItemInfo getItemById(Long itemId) {
        try {
            //调用rest的服务查询商品基本信息
            String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_INFO_URL + itemId);
            if (!StringUtils.isBlank(json)) {
                TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, ItemInfo.class);
                if (taotaoResult.getStatus() == 200){
                    ItemInfo item = (ItemInfo) taotaoResult.getData();
                    return item;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 取商品描述
     * @param itemId
     * @return
     */
    @Override
    public String getItemDescById(Long itemId) {
        try {
            //查询商品描述
            String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_DESC_URL + itemId);
            //转换成java对象
            TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, TbItemDesc.class);
            if (taotaoResult.getStatus() == 200) {
                TbItemDesc itemDesc= (TbItemDesc) taotaoResult.getData();
                //取商品描述信息
                String result = itemDesc.getItemDesc();
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据商品Id查询规格参数
     * @param itemId
     * @return
     */
    @Override
    public String getItemParam(Long itemId) {
        try {
            String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_PARAM_URL + itemId);
            //把json转换成java对象
            TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, TbItemParamItem.class);
            if (taotaoResult.getStatus() == 200) {
                TbItemParamItem itemParamItem = (TbItemParamItem) taotaoResult.getData();
                String paramData = itemParamItem.getParamData();
                //生成html
                //把规格参数json数据转换成java对象
                List<Map> jsonList = JsonUtils.jsonToList(paramData, Map.class);
                StringBuffer sb = new StringBuffer();
                sb.append("<div class=\"Ptable\">\n");
                for (Map m1:jsonList) {
                    sb.append("    <div class=\"Ptable-item\">\n");
                    sb.append("        <h3>"+m1.get("group")+"</h3>\n");
                    sb.append("        <dl>\n");
                    List<Map> list2 = (List<Map>) m1.get("params");
                    for (Map m2 : list2) {
                        sb.append("            <dl class=\"clearfix\" style=\"margin:0\">\n");
                        sb.append("                <dt>"+m2.get("k")+"</dt><dd>"+m2.get("v")+"</dd>\n");
                        sb.append("            </dl>\n");
                    }
                    sb.append("        </dl>\n");
                    sb.append("    </div>\n" );
                }
                sb.append("</div>");
                //返回html判断
                return sb.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
