package com.nice.service.impl;

import com.nice.common.utils.JsonUtils;
import com.nice.mapper.TbItemParamItemMapper;
import com.nice.pojo.TbItemParamItem;
import com.nice.pojo.TbItemParamItemExample;
import com.nice.pojo.TbItemParamItemExample.Criteria;
import com.nice.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 展示商品规格参数
 * @author ningh
 */
@Service
public class ItemParamItemServiceImpl  implements ItemParamItemService {

    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;

    @Override
    public String getItemParamByItemId(Long itemId) {
        //根据商品id查询规格参数
        TbItemParamItemExample example = new TbItemParamItemExample();
        Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        //执行查询
        List<TbItemParamItem> list = itemParamItemMapper.selectByExampleWithBLOBs(example);
        if (list == null || list.size()==0){
            return "";
        }
        //取规格参数信息
        TbItemParamItem itemParamItem = list.get(0);
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
        return sb.toString();
    }
}
