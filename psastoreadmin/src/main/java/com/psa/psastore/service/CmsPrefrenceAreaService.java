package com.psa.psastore.service;

import com.psa.psastore.model.CmsPrefrenceArea;

import java.util.List;

/**
 * 商品优选管理Service
 * Created by macro on 2018/6/1.
 */
public interface CmsPrefrenceAreaService {
    /**
     * 获取所有优选专区
     */
    List<CmsPrefrenceArea> listAll();
}
