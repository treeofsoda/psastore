package com.psa.psastore.dao;

import com.psa.psastore.model.PmsMemberPrice;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PmsMemberPriceDaoTest {
    @Test
    void testInsertList() {
        PmsMemberPriceDao dao = Mockito.mock(PmsMemberPriceDao.class);
        List<PmsMemberPrice> list = Collections.singletonList(new PmsMemberPrice());
        Mockito.when(dao.insertList(list)).thenReturn(1);
        int result = dao.insertList(list);
        assertEquals(1, result);
    }
}
