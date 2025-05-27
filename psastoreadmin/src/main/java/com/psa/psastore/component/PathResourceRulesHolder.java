package com.psa.psastore.component;

import com.psa.psastore.service.UmsResourceService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 路径与资源访问对应关系操作组件
 * Created by macro on 2020/7/17.
 */
@Component
public class PathResourceRulesHolder {

    @Autowired
    private UmsResourceService resourceService;

    @PostConstruct
    public void initPathResourceMap(){
        resourceService.initPathResourceMap();
    }
}
