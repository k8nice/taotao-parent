package com.nice.rest.service;

import com.nice.common.utils.TaotaoResult;

/**
 * @author ningh
 */
public interface RedisService {

    TaotaoResult syncContent(long contentCid);

}
