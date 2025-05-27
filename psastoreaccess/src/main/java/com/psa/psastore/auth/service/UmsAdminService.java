package com.psa.psastore.auth.service;

import com.psa.psastore.auth.domain.UmsAdminLoginParam;
import com.psa.psastore.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @auther macrozheng
 * @description 后台用户服务远程调用Service
 * @date 2024/1/30
 * @github https://github.com/macrozheng
 */
@FeignClient("psastoreadmin")
public interface UmsAdminService {

    @PostMapping("/admin/login")
    CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam);
}
