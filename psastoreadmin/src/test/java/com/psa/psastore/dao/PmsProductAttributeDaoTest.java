package com.psa.psastore.dao;

import com.psa.psastore.dto.ProductAttrInfo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PmsProductAttributeDaoTest {
    @Test
    void testGetProductAttrInfo() {
        PmsProductAttributeDao dao = Mockito.mock(PmsProductAttributeDao.class);
        List<ProductAttrInfo> mockList = Collections.singletonList(new ProductAttrInfo());
        Mockito.when(dao.getProductAttrInfo(1L)).thenReturn(mockList);
        List<ProductAttrInfo> result = dao.getProductAttrInfo(1L);
        assertNotNull(result);
        assertEquals(1, result.size());
    }
}
