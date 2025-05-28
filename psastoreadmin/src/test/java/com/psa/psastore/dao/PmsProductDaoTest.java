package com.psa.psastore.dao;

import com.psa.psastore.dto.PmsProductResult;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class PmsProductDaoTest {
    @Test
    void testGetUpdateInfo() {
        PmsProductDao dao = Mockito.mock(PmsProductDao.class);
        PmsProductResult mockResult = new PmsProductResult();
        Mockito.when(dao.getUpdateInfo(1L)).thenReturn(mockResult);
        PmsProductResult result = dao.getUpdateInfo(1L);
        assertNotNull(result);
    }
}
