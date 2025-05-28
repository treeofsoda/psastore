package com.psa.psastore.controller;

import com.psa.psastore.dto.UmsMenuNode;
import com.psa.psastore.model.UmsMenu;
import com.psa.psastore.service.UmsMenuService;
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
 * Unit tests for UmsMenuController.
 * All comments, assertions, and test data are in English.
 */
public class UmsMenuControllerTest {
    private MockMvc mockMvc;
    @Mock
    private UmsMenuService menuService;
    @InjectMocks
    private UmsMenuController umsMenuController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(umsMenuController).build();
    }

    @Test
    public void testCreate_Success() throws Exception {
        UmsMenu menu = new UmsMenu();
        when(menuService.create(any(UmsMenu.class))).thenReturn(1);
        mockMvc.perform(post("/menu/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testCreate_Failed() throws Exception {
        when(menuService.create(any(UmsMenu.class))).thenReturn(0);
        mockMvc.perform(post("/menu/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testUpdate_Success() throws Exception {
        when(menuService.update(anyLong(), any(UmsMenu.class))).thenReturn(1);
        mockMvc.perform(post("/menu/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdate_Failed() throws Exception {
        when(menuService.update(anyLong(), any(UmsMenu.class))).thenReturn(0);
        mockMvc.perform(post("/menu/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testGetItem() throws Exception {
        UmsMenu menu = new UmsMenu();
        menu.setId(1L);
        when(menuService.getItem(1L)).thenReturn(menu);
        mockMvc.perform(get("/menu/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1L));
    }

    @Test
    public void testDelete_Success() throws Exception {
        when(menuService.delete(1L)).thenReturn(1);
        mockMvc.perform(post("/menu/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testDelete_Failed() throws Exception {
        when(menuService.delete(1L)).thenReturn(0);
        mockMvc.perform(post("/menu/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testList() throws Exception {
        List<UmsMenu> menuList = Arrays.asList(new UmsMenu(), new UmsMenu());
        when(menuService.list(anyLong(), anyInt(), anyInt())).thenReturn(menuList);
        mockMvc.perform(get("/menu/list/1")
                .param("pageSize", "5")
                .param("pageNum", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list").isArray());
    }

    @Test
    public void testTreeList() throws Exception {
        List<UmsMenuNode> nodeList = Arrays.asList(new UmsMenuNode(), new UmsMenuNode());
        when(menuService.treeList()).thenReturn(nodeList);
        mockMvc.perform(get("/menu/treeList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray());
    }

    @Test
    public void testUpdateHidden_Success() throws Exception {
        when(menuService.updateHidden(anyLong(), anyInt())).thenReturn(1);
        mockMvc.perform(post("/menu/updateHidden/1")
                .param("hidden", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdateHidden_Failed() throws Exception {
        when(menuService.updateHidden(anyLong(), anyInt())).thenReturn(0);
        mockMvc.perform(post("/menu/updateHidden/1")
                .param("hidden", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }
}