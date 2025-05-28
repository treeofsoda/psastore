package com.psa.psastore.controller;

import com.psa.psastore.model.SmsFlashPromotionSession;
import com.psa.psastore.dto.SmsFlashPromotionSessionDetail;
import com.psa.psastore.service.SmsFlashPromotionSessionService;
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
 * Unit tests for SmsFlashPromotionSessionController.
 * All comments, assertions, and test data are in English.
 */
public class SmsFlashPromotionSessionControllerTest {
    private MockMvc mockMvc;
    @Mock
    private SmsFlashPromotionSessionService sessionService;
    @InjectMocks
    private SmsFlashPromotionSessionController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testCreate_Success() throws Exception {
        when(sessionService.create(any(SmsFlashPromotionSession.class))).thenReturn(1);
        mockMvc.perform(post("/flashSession/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testCreate_Failed() throws Exception {
        when(sessionService.create(any(SmsFlashPromotionSession.class))).thenReturn(0);
        mockMvc.perform(post("/flashSession/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testUpdate() throws Exception {
        when(sessionService.update(anyLong(), any(SmsFlashPromotionSession.class))).thenReturn(1);
        mockMvc.perform(post("/flashSession/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdate_Failed() throws Exception {
        when(sessionService.update(anyLong(), any(SmsFlashPromotionSession.class))).thenReturn(0);
        mockMvc.perform(post("/flashSession/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testDelete() throws Exception {
        when(sessionService.delete(anyLong())).thenReturn(1);
        mockMvc.perform(post("/flashSession/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdateStatus() throws Exception {
        when(sessionService.updateStatus(anyLong(), anyInt())).thenReturn(1);
        mockMvc.perform(post("/flashSession/update/status/1")
                .param("status", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testGetItem() throws Exception {
        when(sessionService.getItem(anyLong())).thenReturn(new SmsFlashPromotionSession());
        mockMvc.perform(get("/flashSession/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").exists());
    }

    @Test
    public void testList() throws Exception {
        List<SmsFlashPromotionSession> list = Arrays.asList(new SmsFlashPromotionSession(), new SmsFlashPromotionSession());
        when(sessionService.list()).thenReturn(list);
        mockMvc.perform(get("/flashSession/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray());
    }

    @Test
    public void testSelectList() throws Exception {
        List<SmsFlashPromotionSessionDetail> list = Arrays.asList(new SmsFlashPromotionSessionDetail(), new SmsFlashPromotionSessionDetail());
        when(sessionService.selectList(anyLong())).thenReturn(list);
        mockMvc.perform(get("/flashSession/selectList")
                .param("flashPromotionId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray());
    }
}