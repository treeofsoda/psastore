package com.psa.psastore.dao;

import com.psa.psastore.dto.PmsProductCategoryWithChildrenItem;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PmsProductCategoryDaoTest {
    @Test
    void testListWithChildren() {
        PmsProductCategoryDao dao = Mockito.mock(PmsProductCategoryDao.class);
        List<PmsProductCategoryWithChildrenItem> mockList = Collections.singletonList(new PmsProductCategoryWithChildrenItem());
        Mockito.when(dao.listWithChildren()).thenReturn(mockList);
        List<PmsProductCategoryWithChildrenItem> result = dao.listWithChildren();
        assertNotNull(result);
        assertEquals(1, result.size());
    }
}
