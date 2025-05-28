package com.psa.psastore.dao;

import com.psa.psastore.dto.OmsOrderDeliveryParam;
import com.psa.psastore.dto.OmsOrderDetail;
import com.psa.psastore.dto.OmsOrderQueryParam;
import com.psa.psastore.model.OmsOrder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OmsOrderDaoTest {
    @Test
    void testGetList() {
        OmsOrderDao dao = Mockito.mock(OmsOrderDao.class);
        OmsOrderQueryParam param = new OmsOrderQueryParam();
        List<OmsOrder> mockList = Collections.singletonList(new OmsOrder());
        Mockito.when(dao.getList(param)).thenReturn(mockList);
        List<OmsOrder> result = dao.getList(param);
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testDelivery() {
        OmsOrderDao dao = Mockito.mock(OmsOrderDao.class);
        List<OmsOrderDeliveryParam> list = Collections.singletonList(new OmsOrderDeliveryParam());
        Mockito.when(dao.delivery(list)).thenReturn(1);
        int result = dao.delivery(list);
        assertEquals(1, result);
    }

    @Test
    void testGetDetail() {
        OmsOrderDao dao = Mockito.mock(OmsOrderDao.class);
        OmsOrderDetail detail = new OmsOrderDetail();
        Mockito.when(dao.getDetail(1L)).thenReturn(detail);
        OmsOrderDetail result = dao.getDetail(1L);
        assertNotNull(result);
    }
}
