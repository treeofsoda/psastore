package com.psa.psastore.demo.service;

import com.psa.psastore.common.api.CommonResult;
import com.psa.psastore.demo.dto.UmsAdminLoginParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by macro on 2019/10/18.
 */
@FeignClient("psastoreadmin")
public interface FeignAdminService {

    @PostMapping("/admin/login")
    CommonResult login(@RequestBody UmsAdminLoginParam loginParam);

    @GetMapping("/brand/listAll")
    CommonResult getList();
}
