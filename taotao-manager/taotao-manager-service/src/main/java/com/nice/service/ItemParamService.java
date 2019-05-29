package com.nice.service;

import com.nice.common.utils.TaotaoResult;
import com.nice.pojo.TbItemParam;

/**
 * @author ningh
 */
public interface ItemParamService {

    /**
     * @param cid
     * @return
     */
    TaotaoResult getItemParamByCid(long cid);

    TaotaoResult insertItemParam(TbItemParam itemParam);

}
