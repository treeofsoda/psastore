package com.psa.psastore.service.impl;

import com.psa.psastore.mapper.CmsPrefrenceAreaMapper;
import com.psa.psastore.model.CmsPrefrenceArea;
import com.psa.psastore.model.CmsPrefrenceAreaExample;
import com.psa.psastore.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选管理Service实现类
 * Created by macro on 2018/6/1.
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
