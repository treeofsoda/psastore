package com.psa.psastore.dao;

import com.psa.psastore.dto.OmsOrderReturnApplyResult;
import com.psa.psastore.dto.OmsReturnApplyQueryParam;
import com.psa.psastore.model.OmsOrderReturnApply;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OmsOrderReturnApplyDaoTest {
    @Test
    void testGetList() {
        OmsOrderReturnApplyDao dao = Mockito.mock(OmsOrderReturnApplyDao.class);
        OmsReturnApplyQueryParam param = new OmsReturnApplyQueryParam();
        List<OmsOrderReturnApply> mockList = Collections.singletonList(new OmsOrderReturnApply());
        Mockito.when(dao.getList(param)).thenReturn(mockList);
        List<OmsOrderReturnApply> result = dao.getList(param);
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testGetDetail() {
        OmsOrderReturnApplyDao dao = Mockito.mock(OmsOrderReturnApplyDao.class);
        OmsOrderReturnApplyResult mockResult = new OmsOrderReturnApplyResult();
        Mockito.when(dao.getDetail(1L)).thenReturn(mockResult);
        OmsOrderReturnApplyResult result = dao.getDetail(1L);
        assertNotNull(result);
    }
}
