package com.psa.psastore.dao;

import com.psa.psastore.model.PmsProductAttributeValue;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PmsProductAttributeValueDaoTest {
    @Test
    void testInsertList() {
        PmsProductAttributeValueDao dao = Mockito.mock(PmsProductAttributeValueDao.class);
        List<PmsProductAttributeValue> list = Collections.singletonList(new PmsProductAttributeValue());
        Mockito.when(dao.insertList(list)).thenReturn(1);
        int result = dao.insertList(list);
        assertEquals(1, result);
    }
}
