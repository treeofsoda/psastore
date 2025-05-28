package com.psa.psastore.dao;

import com.psa.psastore.model.PmsSkuStock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PmsSkuStockDaoTest {
    @Test
    void testInsertList() {
        PmsSkuStockDao dao = Mockito.mock(PmsSkuStockDao.class);
        List<PmsSkuStock> list = Collections.singletonList(new PmsSkuStock());
        Mockito.when(dao.insertList(list)).thenReturn(1);
        int result = dao.insertList(list);
        assertEquals(1, result);
    }

    @Test
    void testReplaceList() {
        PmsSkuStockDao dao = Mockito.mock(PmsSkuStockDao.class);
        List<PmsSkuStock> list = Collections.singletonList(new PmsSkuStock());
        Mockito.when(dao.replaceList(list)).thenReturn(1);
        int result = dao.replaceList(list);
        assertEquals(1, result);
    }
}
