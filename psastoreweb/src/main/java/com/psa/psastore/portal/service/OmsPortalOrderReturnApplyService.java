package com.psa.psastore.portal.service;

import com.psa.psastore.portal.domain.OmsOrderReturnApplyParam;

/**
 * 订单退货管理Service
 * Created by macro on 2018/10/17.
 */
public interface OmsPortalOrderReturnApplyService {
    /**
     * 提交申请
     */
    int create(OmsOrderReturnApplyParam returnApply);
}
