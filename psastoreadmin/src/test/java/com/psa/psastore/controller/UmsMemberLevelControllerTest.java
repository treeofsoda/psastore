package com.psa.psastore.controller;

import com.psa.psastore.model.UmsMemberLevel;
import com.psa.psastore.service.UmsMemberLevelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.ArgumentMatchers.anyInt;

/**
 * Unit tests for UmsMemberLevelController.
 * All comments, assertions, and test data are in English.
 */
public class UmsMemberLevelControllerTest {
    private MockMvc mockMvc;
    @Mock
    private UmsMemberLevelService memberLevelService;
    @InjectMocks
    private UmsMemberLevelController umsMemberLevelController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(umsMemberLevelController).build();
    }

    @Test
    public void testList() throws Exception {
        List<UmsMemberLevel> levelList = Arrays.asList(new UmsMemberLevel(), new UmsMemberLevel());
        when(memberLevelService.list(anyInt())).thenReturn(levelList);
        mockMvc.perform(get("/memberLevel/list")
                .param("defaultStatus", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray());
    }
}