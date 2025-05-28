package com.psa.psastore.dao;

import com.psa.psastore.model.SmsCouponProductRelation;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SmsCouponProductRelationDaoTest {
    @Test
    void testInsertList() {
        SmsCouponProductRelationDao dao = Mockito.mock(SmsCouponProductRelationDao.class);
        List<SmsCouponProductRelation> list = Collections.singletonList(new SmsCouponProductRelation());
        Mockito.when(dao.insertList(list)).thenReturn(1);
        int result = dao.insertList(list);
        assertEquals(1, result);
    }
}
