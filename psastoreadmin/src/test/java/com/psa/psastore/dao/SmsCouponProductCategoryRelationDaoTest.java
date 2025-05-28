package com.psa.psastore.dao;

import com.psa.psastore.model.SmsCouponProductCategoryRelation;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SmsCouponProductCategoryRelationDaoTest {
    @Test
    void testInsertList() {
        SmsCouponProductCategoryRelationDao dao = Mockito.mock(SmsCouponProductCategoryRelationDao.class);
        List<SmsCouponProductCategoryRelation> list = Collections.singletonList(new SmsCouponProductCategoryRelation());
        Mockito.when(dao.insertList(list)).thenReturn(1);
        int result = dao.insertList(list);
        assertEquals(1, result);
    }
}
