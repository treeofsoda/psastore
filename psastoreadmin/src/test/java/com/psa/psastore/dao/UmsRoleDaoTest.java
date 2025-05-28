package com.psa.psastore.dao;

import com.psa.psastore.model.UmsMenu;
import com.psa.psastore.model.UmsResource;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UmsRoleDaoTest {
    @Test
    void testGetMenuList() {
        UmsRoleDao dao = Mockito.mock(UmsRoleDao.class);
        List<UmsMenu> mockList = Collections.singletonList(new UmsMenu());
        Mockito.when(dao.getMenuList(1L)).thenReturn(mockList);
        List<UmsMenu> result = dao.getMenuList(1L);
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testGetMenuListByRoleId() {
        UmsRoleDao dao = Mockito.mock(UmsRoleDao.class);
        List<UmsMenu> mockList = Collections.singletonList(new UmsMenu());
        Mockito.when(dao.getMenuListByRoleId(1L)).thenReturn(mockList);
        List<UmsMenu> result = dao.getMenuListByRoleId(1L);
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testGetResourceListByRoleId() {
        UmsRoleDao dao = Mockito.mock(UmsRoleDao.class);
        List<UmsResource> mockList = Collections.singletonList(new UmsResource());
        Mockito.when(dao.getResourceListByRoleId(1L)).thenReturn(mockList);
        List<UmsResource> result = dao.getResourceListByRoleId(1L);
        assertNotNull(result);
        assertEquals(1, result.size());
    }
}
