package com.psa.psastore.portal.domain;

import com.psa.psastore.model.PmsProductCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 商品分类，包含子分类
 * Created by macro on 2020/4/6.
 */
@Getter
@Setter
public class PmsProductCategoryNode extends PmsProductCategory {
    private List<PmsProductCategoryNode> children;
}
