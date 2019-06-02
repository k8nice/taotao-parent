package com.nice.rest.service;

import com.nice.pojo.TbContent;

import java.util.List;

/**
 * @author ningh
 */
public interface ContentService {

    List<TbContent> getContentList(long contentCid);

}
