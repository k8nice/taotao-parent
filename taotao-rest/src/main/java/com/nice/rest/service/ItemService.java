package com.nice.rest.service;

import com.nice.common.utils.TaotaoResult;

/**
 * @author ningh
 */
public interface ItemService {

    TaotaoResult getItemBaseInfo(Long itemId);

    TaotaoResult getItemDesc(long itemId);

    TaotaoResult getItemParam(long itemId);

}
