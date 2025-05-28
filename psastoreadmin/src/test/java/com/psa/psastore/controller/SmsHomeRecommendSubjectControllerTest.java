package com.psa.psastore.controller;

import com.psa.psastore.model.SmsHomeRecommendSubject;
import com.psa.psastore.service.SmsHomeRecommendSubjectService;
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
 * Unit tests for SmsHomeRecommendSubjectController.
 * All comments, assertions, and test data are in English.
 */
public class SmsHomeRecommendSubjectControllerTest {
    private MockMvc mockMvc;
    @Mock
    private SmsHomeRecommendSubjectService recommendSubjectService;
    @InjectMocks
    private SmsHomeRecommendSubjectController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testCreate_Success() throws Exception {
        when(recommendSubjectService.create(anyList())).thenReturn(1);
        mockMvc.perform(post("/home/recommendSubject/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[]"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testCreate_Failed() throws Exception {
        when(recommendSubjectService.create(anyList())).thenReturn(0);
        mockMvc.perform(post("/home/recommendSubject/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[]"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }

    @Test
    public void testUpdateSort() throws Exception {
        when(recommendSubjectService.updateSort(anyLong(), anyInt())).thenReturn(1);
        mockMvc.perform(post("/home/recommendSubject/update/sort/1")
                .param("sort", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testDelete() throws Exception {
        when(recommendSubjectService.delete(anyList())).thenReturn(1);
        mockMvc.perform(post("/home/recommendSubject/delete")
                .param("ids", "1,2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testUpdateRecommendStatus() throws Exception {
        when(recommendSubjectService.updateRecommendStatus(anyList(), anyInt())).thenReturn(1);
        mockMvc.perform(post("/home/recommendSubject/update/recommendStatus")
                .param("ids", "1,2")
                .param("recommendStatus", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testList() throws Exception {
        List<SmsHomeRecommendSubject> list = Arrays.asList(new SmsHomeRecommendSubject(), new SmsHomeRecommendSubject());
        when(recommendSubjectService.list(anyString(), anyInt(), anyInt(), anyInt())).thenReturn(list);
        mockMvc.perform(get("/home/recommendSubject/list")
                .param("subjectName", "test")
                .param("recommendStatus", "1")
                .param("pageSize", "5")
                .param("pageNum", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.list").isArray());
    }
}