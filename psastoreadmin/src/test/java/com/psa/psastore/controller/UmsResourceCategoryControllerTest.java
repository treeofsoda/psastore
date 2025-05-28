package com.psa.psastore.controller;

import com.psa.psastore.model.UmsResourceCategory;
import com.psa.psastore.service.UmsResourceCategoryService;
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
 * Unit tests for UmsResourceCategoryController.
 * All comments, assertions, and test data are in English.
 */
public class UmsResourceCategoryControllerTest {
    private MockMvc mockMvc;
    @Mock
    private UmsResourceCategoryService resourceCategoryService;
    @InjectMocks
    private UmsResourceCategoryController umsResourceCategoryController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(umsResourceCategoryController).build();
    }

    @Test
    public void testCreate_Success() throws Exception {
        when(resourceCategoryService.create(any(UmsResourceCategory.class))).thenReturn(1);
        mockMvc.perform(post("/resourceCategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testCreate_Failed() throws Exception {
        when(resourceCategoryService.create(any(UmsResourceCategory.class))).thenReturn(0);
        mockMvc.perform(post("/resourceCategory/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testUpdate_Success() throws Exception {
        when(resourceCategoryService.update(anyLong(), any(UmsResourceCategory.class))).thenReturn(1);
        mockMvc.perform(post("/resourceCategory/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdate_Failed() throws Exception {
        when(resourceCategoryService.update(anyLong(), any(UmsResourceCategory.class))).thenReturn(0);
        mockMvc.perform(post("/resourceCategory/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testDelete_Success() throws Exception {
        when(resourceCategoryService.delete(1L)).thenReturn(1);
        mockMvc.perform(post("/resourceCategory/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testDelete_Failed() throws Exception {
        when(resourceCategoryService.delete(1L)).thenReturn(0);
        mockMvc.perform(post("/resourceCategory/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testListAll() throws Exception {
        List<UmsResourceCategory> categoryList = Arrays.asList(new UmsResourceCategory(), new UmsResourceCategory());
        when(resourceCategoryService.listAll()).thenReturn(categoryList);
        mockMvc.perform(get("/resourceCategory/listAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray());
    }
}