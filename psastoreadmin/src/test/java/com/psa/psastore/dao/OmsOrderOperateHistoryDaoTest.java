package com.psa.psastore.dao;

import com.psa.psastore.model.OmsOrderOperateHistory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OmsOrderOperateHistoryDaoTest {
    @Test
    void testInsertList() {
        OmsOrderOperateHistoryDao dao = Mockito.mock(OmsOrderOperateHistoryDao.class);
        List<OmsOrderOperateHistory> list = Collections.singletonList(new OmsOrderOperateHistory());
        Mockito.when(dao.insertList(list)).thenReturn(1);
        int result = dao.insertList(list);
        assertEquals(1, result);
    }
}
