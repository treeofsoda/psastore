package com.psa.psastore.dao;

import com.psa.psastore.model.UmsAdminRoleRelation;
import com.psa.psastore.model.UmsResource;
import com.psa.psastore.model.UmsRole;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UmsAdminRoleRelationDaoTest {
    @Test
    void testInsertList() {
        UmsAdminRoleRelationDao dao = Mockito.mock(UmsAdminRoleRelationDao.class);
        List<UmsAdminRoleRelation> list = Collections.singletonList(new UmsAdminRoleRelation());
        Mockito.when(dao.insertList(list)).thenReturn(1);
        int result = dao.insertList(list);
        assertEquals(1, result);
    }

    @Test
    void testGetRoleList() {
        UmsAdminRoleRelationDao dao = Mockito.mock(UmsAdminRoleRelationDao.class);
        List<UmsRole> mockList = Collections.singletonList(new UmsRole());
        Mockito.when(dao.getRoleList(1L)).thenReturn(mockList);
        List<UmsRole> result = dao.getRoleList(1L);
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testGetResourceList() {
        UmsAdminRoleRelationDao dao = Mockito.mock(UmsAdminRoleRelationDao.class);
        List<UmsResource> mockList = Collections.singletonList(new UmsResource());
        Mockito.when(dao.getResourceList(1L)).thenReturn(mockList);
        List<UmsResource> result = dao.getResourceList(1L);
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testGetAdminIdList() {
        UmsAdminRoleRelationDao dao = Mockito.mock(UmsAdminRoleRelationDao.class);
        List<Long> mockList = Collections.singletonList(1L);
        Mockito.when(dao.getAdminIdList(1L)).thenReturn(mockList);
        List<Long> result = dao.getAdminIdList(1L);
        assertNotNull(result);
        assertEquals(1, result.size());
    }
}
