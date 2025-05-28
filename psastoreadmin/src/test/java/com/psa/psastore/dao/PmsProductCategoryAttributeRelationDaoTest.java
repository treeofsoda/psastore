package com.psa.psastore.dao;

import com.psa.psastore.model.PmsProductCategoryAttributeRelation;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PmsProductCategoryAttributeRelationDaoTest {
    @Test
    void testInsertList() {
        PmsProductCategoryAttributeRelationDao dao = Mockito.mock(PmsProductCategoryAttributeRelationDao.class);
        List<PmsProductCategoryAttributeRelation> list = Collections.singletonList(new PmsProductCategoryAttributeRelation());
        Mockito.when(dao.insertList(list)).thenReturn(1);
        int result = dao.insertList(list);
        assertEquals(1, result);
    }
}
