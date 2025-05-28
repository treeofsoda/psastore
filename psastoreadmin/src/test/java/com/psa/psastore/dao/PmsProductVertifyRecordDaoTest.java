package com.psa.psastore.dao;

import com.psa.psastore.model.PmsProductVertifyRecord;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PmsProductVertifyRecordDaoTest {
    @Test
    void testInsertList() {
        PmsProductVertifyRecordDao dao = Mockito.mock(PmsProductVertifyRecordDao.class);
        List<PmsProductVertifyRecord> list = Collections.singletonList(new PmsProductVertifyRecord());
        Mockito.when(dao.insertList(list)).thenReturn(1);
        int result = dao.insertList(list);
        assertEquals(1, result);
    }
}
