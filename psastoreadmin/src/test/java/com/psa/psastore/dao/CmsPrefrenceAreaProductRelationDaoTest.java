package com.psa.psastore.dao;

import com.psa.psastore.model.CmsPrefrenceAreaProductRelation;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CmsPrefrenceAreaProductRelationDaoTest {
    @Test
    void testInsertList() {
        CmsPrefrenceAreaProductRelationDao dao = Mockito.mock(CmsPrefrenceAreaProductRelationDao.class);
        List<CmsPrefrenceAreaProductRelation> list = Collections.singletonList(new CmsPrefrenceAreaProductRelation());
        Mockito.when(dao.insertList(list)).thenReturn(1);
        int result = dao.insertList(list);
        assertEquals(1, result);
    }
}
