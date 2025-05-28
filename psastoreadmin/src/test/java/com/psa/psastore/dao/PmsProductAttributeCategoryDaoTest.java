package com.psa.psastore.dao;

import com.psa.psastore.dto.PmsProductAttributeCategoryItem;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PmsProductAttributeCategoryDaoTest {
    @Test
    void testGetListWithAttr() {
        PmsProductAttributeCategoryDao dao = Mockito.mock(PmsProductAttributeCategoryDao.class);
        List<PmsProductAttributeCategoryItem> mockList = Collections.singletonList(new PmsProductAttributeCategoryItem());
        Mockito.when(dao.getListWithAttr()).thenReturn(mockList);
        List<PmsProductAttributeCategoryItem> result = dao.getListWithAttr();
        assertNotNull(result);
        assertEquals(1, result.size());
    }
}
