package com.psa.psastore.dao;

import com.psa.psastore.model.PmsProductLadder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PmsProductLadderDaoTest {
    @Test
    void testInsertList() {
        PmsProductLadderDao dao = Mockito.mock(PmsProductLadderDao.class);
        List<PmsProductLadder> list = Collections.singletonList(new PmsProductLadder());
        Mockito.when(dao.insertList(list)).thenReturn(1);
        int result = dao.insertList(list);
        assertEquals(1, result);
    }
}
