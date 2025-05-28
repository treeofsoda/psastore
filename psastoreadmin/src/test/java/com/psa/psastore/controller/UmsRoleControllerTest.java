package com.psa.psastore.controller;

import com.psa.psastore.model.UmsRole;
import com.psa.psastore.model.UmsMenu;
import com.psa.psastore.model.UmsResource;
import com.psa.psastore.service.UmsRoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for UmsRoleController.
 * All comments, assertions, and test data are in English.
 */
public class UmsRoleControllerTest {
    private MockMvc mockMvc;
    @Mock
    private UmsRoleService roleService;
    @InjectMocks
    private UmsRoleController umsRoleController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(umsRoleController).build();
    }

    @Test
    public void testCreate_Success() throws Exception {
        UmsRole role = new UmsRole();
        when(roleService.create(any(UmsRole.class))).thenReturn(1);
        mockMvc.perform(post("/role/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testCreate_Failed() throws Exception {
        when(roleService.create(any(UmsRole.class))).thenReturn(0);
        mockMvc.perform(post("/role/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testUpdate_Success() throws Exception {
        when(roleService.update(anyLong(), any(UmsRole.class))).thenReturn(1);
        mockMvc.perform(post("/role/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdate_Failed() throws Exception {
        when(roleService.update(anyLong(), any(UmsRole.class))).thenReturn(0);
        mockMvc.perform(post("/role/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testDelete_Success() throws Exception {
        when(roleService.delete(anyList())).thenReturn(1);
        mockMvc.perform(post("/role/delete")
                .param("ids", "1,2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testDelete_Failed() throws Exception {
        when(roleService.delete(anyList())).thenReturn(0);
        mockMvc.perform(post("/role/delete")
                .param("ids", "1,2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testList() throws Exception {
        List<UmsRole> roleList = Arrays.asList(new UmsRole(), new UmsRole());
        when(roleService.list()).thenReturn(roleList);
        mockMvc.perform(get("/role/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray());
    }

    @Test
    public void testListAll() throws Exception {
        List<UmsRole> roleList = Arrays.asList(new UmsRole(), new UmsRole());
        when(roleService.list()).thenReturn(roleList);
        mockMvc.perform(get("/role/listAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray());
    }

    @Test
    public void testListMenu() throws Exception {
        List<UmsMenu> menuList = Arrays.asList(new UmsMenu(), new UmsMenu());
        when(roleService.listMenu(1L)).thenReturn(menuList);
        mockMvc.perform(get("/role/listMenu/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray());
    }

    @Test
    public void testListResource() throws Exception {
        List<UmsResource> resourceList = Arrays.asList(new UmsResource(), new UmsResource());
        when(roleService.listResource(1L)).thenReturn(resourceList);
        mockMvc.perform(get("/role/listResource/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray());
    }

    @Test
    public void testAllocMenu() throws Exception {
        when(roleService.allocMenu(anyLong(), anyList())).thenReturn(2);
        mockMvc.perform(post("/role/allocMenu")
                .param("roleId", "1")
                .param("menuIds", "1,2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testAllocResource() throws Exception {
        when(roleService.allocResource(anyLong(), anyList())).thenReturn(2);
        mockMvc.perform(post("/role/allocResource")
                .param("roleId", "1")
                .param("resourceIds", "1,2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }
}