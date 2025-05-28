package com.psa.psastore.dao;

import com.psa.psastore.model.CmsSubjectProductRelation;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CmsSubjectProductRelationDaoTest {
    @Test
    void testInsertList() {
        CmsSubjectProductRelationDao dao = Mockito.mock(CmsSubjectProductRelationDao.class);
        List<CmsSubjectProductRelation> list = Collections.singletonList(new CmsSubjectProductRelation());
        Mockito.when(dao.insertList(list)).thenReturn(1);
        int result = dao.insertList(list);
        assertEquals(1, result);
    }
}
