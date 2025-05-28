package com.psa.psastore.controller;

import com.psa.psastore.model.UmsResource;
import com.psa.psastore.service.UmsResourceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for UmsResourceController.
 * All comments, assertions, and test data are in English.
 */
public class UmsResourceControllerTest {
    private MockMvc mockMvc;
    @Mock
    private UmsResourceService resourceService;
    @InjectMocks
    private UmsResourceController umsResourceController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(umsResourceController).build();
    }

    @Test
    public void testCreate_Success() throws Exception {
        UmsResource resource = new UmsResource();
        when(resourceService.create(any(UmsResource.class))).thenReturn(1);
        mockMvc.perform(post("/resource/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testCreate_Failed() throws Exception {
        when(resourceService.create(any(UmsResource.class))).thenReturn(0);
        mockMvc.perform(post("/resource/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testUpdate_Success() throws Exception {
        when(resourceService.update(anyLong(), any(UmsResource.class))).thenReturn(1);
        mockMvc.perform(post("/resource/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdate_Failed() throws Exception {
        when(resourceService.update(anyLong(), any(UmsResource.class))).thenReturn(0);
        mockMvc.perform(post("/resource/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testGetItem() throws Exception {
        UmsResource resource = new UmsResource();
        resource.setId(1L);
        when(resourceService.getItem(1L)).thenReturn(resource);
        mockMvc.perform(get("/resource/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1L));
    }

    @Test
    public void testDelete_Success() throws Exception {
        when(resourceService.delete(1L)).thenReturn(1);
        mockMvc.perform(post("/resource/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testDelete_Failed() throws Exception {
        when(resourceService.delete(1L)).thenReturn(0);
        mockMvc.perform(post("/resource/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testList() throws Exception {
        List<UmsResource> resourceList = Arrays.asList(new UmsResource(), new UmsResource());
        when(resourceService.list(any(), any(), any(), anyInt(), anyInt())).thenReturn(resourceList);
        mockMvc.perform(get("/resource/list")
                .param("categoryId", "1")
                .param("nameKeyword", "test")
                .param("urlKeyword", "url")
                .param("pageSize", "5")
                .param("pageNum", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list").isArray());
    }

    @Test
    public void testListAll() throws Exception {
        List<UmsResource> resourceList = Arrays.asList(new UmsResource(), new UmsResource());
        when(resourceService.listAll()).thenReturn(resourceList);
        mockMvc.perform(get("/resource/listAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray());
    }
}