package com.psa.psastore.controller;

import com.psa.psastore.model.SmsFlashPromotion;
import com.psa.psastore.service.SmsFlashPromotionService;
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
 * Unit tests for SmsFlashPromotionController.
 * All comments, assertions, and test data are in English.
 */
public class SmsFlashPromotionControllerTest {
    private MockMvc mockMvc;
    @Mock
    private SmsFlashPromotionService flashPromotionService;
    @InjectMocks
    private SmsFlashPromotionController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testCreate_Success() throws Exception {
        when(flashPromotionService.create(any(SmsFlashPromotion.class))).thenReturn(1);
        mockMvc.perform(post("/flash/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testCreate_Failed() throws Exception {
        when(flashPromotionService.create(any(SmsFlashPromotion.class))).thenReturn(0);
        mockMvc.perform(post("/flash/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testUpdate() throws Exception {
        when(flashPromotionService.update(anyLong(), any(SmsFlashPromotion.class))).thenReturn(1);
        mockMvc.perform(post("/flash/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdate_Failed() throws Exception {
        when(flashPromotionService.update(anyLong(), any(SmsFlashPromotion.class))).thenReturn(0);
        mockMvc.perform(post("/flash/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testDelete() throws Exception {
        when(flashPromotionService.delete(anyLong())).thenReturn(1);
        mockMvc.perform(post("/flash/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdateStatus() throws Exception {
        when(flashPromotionService.updateStatus(anyLong(), anyInt())).thenReturn(1);
        mockMvc.perform(post("/flash/update/status/1")
                .param("status", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testGetItem() throws Exception {
        when(flashPromotionService.getItem(anyLong())).thenReturn(new SmsFlashPromotion());
        mockMvc.perform(get("/flash/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").exists());
    }

    @Test
    public void testList() throws Exception {
        List<SmsFlashPromotion> list = Arrays.asList(new SmsFlashPromotion(), new SmsFlashPromotion());
        when(flashPromotionService.list(anyString(), anyInt(), anyInt())).thenReturn(list);
        mockMvc.perform(get("/flash/list")
                .param("keyword", "test")
                .param("pageSize", "5")
                .param("pageNum", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list").isArray());
    }
}