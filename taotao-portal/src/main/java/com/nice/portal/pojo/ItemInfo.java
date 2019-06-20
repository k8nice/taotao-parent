package com.nice.portal.pojo;

import com.nice.pojo.TbItem;

/**
 * 商品pojo
 * @author ningh
 */
public class ItemInfo extends TbItem {

    public String[] getImages(){
        String image = getImage();
        if (image != null){
            String[] images = image.split(",");
            return images;
        }
        return null;
    }

}
