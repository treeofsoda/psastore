package com.psa.psastore.dao;

import com.psa.psastore.dto.SmsCouponParam;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class SmsCouponDaoTest {
    @Test
    void testGetItem() {
        SmsCouponDao dao = Mockito.mock(SmsCouponDao.class);
        SmsCouponParam mockResult = new SmsCouponParam();
        Mockito.when(dao.getItem(1L)).thenReturn(mockResult);
        SmsCouponParam result = dao.getItem(1L);
        assertNotNull(result);
    }
}
