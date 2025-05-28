package com.psa.psastore.controller;

import com.psa.psastore.model.SmsHomeAdvertise;
import com.psa.psastore.service.SmsHomeAdvertiseService;
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
 * Unit tests for SmsHomeAdvertiseController.
 * All comments, assertions, and test data are in English.
 */
public class SmsHomeAdvertiseControllerTest {
    private MockMvc mockMvc;
    @Mock
    private SmsHomeAdvertiseService advertiseService;
    @InjectMocks
    private SmsHomeAdvertiseController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testCreate_Success() throws Exception {
        when(advertiseService.create(any(SmsHomeAdvertise.class))).thenReturn(1);
        mockMvc.perform(post("/home/advertise/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testCreate_Failed() throws Exception {
        when(advertiseService.create(any(SmsHomeAdvertise.class))).thenReturn(0);
        mockMvc.perform(post("/home/advertise/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testDelete() throws Exception {
        when(advertiseService.delete(anyList())).thenReturn(1);
        mockMvc.perform(post("/home/advertise/delete")
                .param("ids", "1,2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdateStatus() throws Exception {
        when(advertiseService.updateStatus(anyLong(), anyInt())).thenReturn(1);
        mockMvc.perform(post("/home/advertise/update/status/1")
                .param("status", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testGetItem() throws Exception {
        when(advertiseService.getItem(anyLong())).thenReturn(new SmsHomeAdvertise());
        mockMvc.perform(get("/home/advertise/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").exists());
    }

    @Test
    public void testUpdate() throws Exception {
        when(advertiseService.update(anyLong(), any(SmsHomeAdvertise.class))).thenReturn(1);
        mockMvc.perform(post("/home/advertise/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testList() throws Exception {
        List<SmsHomeAdvertise> list = Arrays.asList(new SmsHomeAdvertise(), new SmsHomeAdvertise());
        when(advertiseService.list(anyString(), anyInt(), anyString(), anyInt(), anyInt())).thenReturn(list);
        mockMvc.perform(get("/home/advertise/list")
                .param("name", "test")
                .param("type", "1")
                .param("endTime", "2024-01-01")
                .param("pageSize", "5")
                .param("pageNum", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list").isArray());
    }
}