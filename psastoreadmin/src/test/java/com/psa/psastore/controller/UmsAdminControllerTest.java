package com.psa.psastore.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.psa.psastore.dto.UmsAdminLoginParam;
import com.psa.psastore.dto.UmsAdminParam;
import com.psa.psastore.dto.UpdateAdminPasswordParam;
import com.psa.psastore.model.UmsAdmin;
import com.psa.psastore.service.UmsAdminService;
import com.psa.psastore.service.UmsRoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for UmsAdminController.
 * All comments, assertions, and test data are in English.
 */
public class UmsAdminControllerTest {
    private MockMvc mockMvc;
    @Mock
    private UmsAdminService adminService;
    @Mock
    private UmsRoleService roleService;
    @InjectMocks
    private UmsAdminController umsAdminController;
    @Value("Bearer ")
    private String tokenHead;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(umsAdminController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testRegister_Success() throws Exception {
        UmsAdminParam param = new UmsAdminParam();
        param.setUsername("testuser");
        UmsAdmin admin = new UmsAdmin();
        admin.setUsername("testuser");
        when(adminService.register(any(UmsAdminParam.class))).thenReturn(admin);
        mockMvc.perform(post("/admin/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(param)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.username").value("testuser"));
    }

    @Test
    public void testRegister_Failed() throws Exception {
        UmsAdminParam param = new UmsAdminParam();
        when(adminService.register(any(UmsAdminParam.class))).thenReturn(null);
        mockMvc.perform(post("/admin/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(param)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testLogin_Success() throws Exception {
        UmsAdminLoginParam param = new UmsAdminLoginParam();
        param.setUsername("admin");
        param.setPassword("password");
        SaTokenInfo tokenInfo = new SaTokenInfo();
        tokenInfo.setTokenValue("token123");
        when(adminService.login(anyString(), anyString())).thenReturn(tokenInfo);
        mockMvc.perform(post("/admin/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(param)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.token").value("token123"));
    }

    @Test
    public void testLogin_Failed() throws Exception {
        UmsAdminLoginParam param = new UmsAdminLoginParam();
        param.setUsername("admin");
        param.setPassword("wrong");
        when(adminService.login(anyString(), anyString())).thenReturn(null);
        mockMvc.perform(post("/admin/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(param)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(404));
    }

    @Test
    public void testGetAdminInfo() throws Exception {
        UmsAdmin admin = new UmsAdmin();
        admin.setId(1L);
        admin.setUsername("admin");
        admin.setIcon("icon.png");
        when(adminService.getCurrentAdmin()).thenReturn(admin);
        when(roleService.getMenuList(1L)).thenReturn(Collections.emptyList());
        when(adminService.getRoleList(1L)).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/admin/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.username").value("admin"));
    }

    @Test
    public void testLogout() throws Exception {
        mockMvc.perform(post("/admin/logout"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testList() throws Exception {
        when(adminService.list(anyString(), anyInt(), anyInt())).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/admin/list")
                .param("keyword", "admin")
                .param("pageSize", "5")
                .param("pageNum", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list").isArray());
    }

    @Test
    public void testGetItem() throws Exception {
        UmsAdmin admin = new UmsAdmin();
        admin.setId(1L);
        when(adminService.getItem(1L)).thenReturn(admin);
        mockMvc.perform(get("/admin/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1L));
    }

    @Test
    public void testUpdate_Success() throws Exception {
        UmsAdmin admin = new UmsAdmin();
        when(adminService.update(anyLong(), any(UmsAdmin.class))).thenReturn(1);
        mockMvc.perform(post("/admin/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(admin)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdate_Failed() throws Exception {
        UmsAdmin admin = new UmsAdmin();
        when(adminService.update(anyLong(), any(UmsAdmin.class))).thenReturn(0);
        mockMvc.perform(post("/admin/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(admin)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testUpdatePassword_Success() throws Exception {
        UpdateAdminPasswordParam param = new UpdateAdminPasswordParam();
        when(adminService.updatePassword(any(UpdateAdminPasswordParam.class))).thenReturn(1);
        mockMvc.perform(post("/admin/updatePassword")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(param)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdatePassword_Failed() throws Exception {
        UpdateAdminPasswordParam param = new UpdateAdminPasswordParam();
        when(adminService.updatePassword(any(UpdateAdminPasswordParam.class))).thenReturn(-1);
        mockMvc.perform(post("/admin/updatePassword")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(param)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testDelete_Success() throws Exception {
        when(adminService.delete(1L)).thenReturn(1);
        mockMvc.perform(post("/admin/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testDelete_Failed() throws Exception {
        when(adminService.delete(1L)).thenReturn(0);
        mockMvc.perform(post("/admin/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testUpdateStatus_Success() throws Exception {
        when(adminService.update(anyLong(), any(UmsAdmin.class))).thenReturn(1);
        mockMvc.perform(post("/admin/updateStatus/1")
                .param("status", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdateStatus_Failed() throws Exception {
        when(adminService.update(anyLong(), any(UmsAdmin.class))).thenReturn(0);
        mockMvc.perform(post("/admin/updateStatus/1")
                .param("status", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testUpdateRole_Success() throws Exception {
        when(adminService.updateRole(anyLong(), anyList())).thenReturn(1);
        mockMvc.perform(post("/admin/role/update")
                .param("adminId", "1")
                .param("roleIds", "1,2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdateRole_Failed() throws Exception {
        when(adminService.updateRole(anyLong(), anyList())).thenReturn(0);
        mockMvc.perform(post("/admin/role/update")
                .param("adminId", "1")
                .param("roleIds", "1,2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testGetRoleList() throws Exception {
        when(adminService.getRoleList(1L)).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/admin/role/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray());
    }
}