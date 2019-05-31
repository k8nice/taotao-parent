package com.nice.rest.service;

import com.nice.pojo.TbContent;

import java.util.List;

public interface ContentService {

    List<TbContent> getContentList(long contentCid);

}
