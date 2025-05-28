package com.psa.psastore.controller;

import com.psa.psastore.service.CmsSubjectService;
import com.psa.psastore.model.CmsSubject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CmsSubjectController.class)
public class CmsSubjectControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CmsSubjectService subjectService;

    @Test
    public void testListAll_Success() throws Exception {
        Mockito.when(subjectService.listAll()).thenReturn(Collections.singletonList(new CmsSubject()));
        mockMvc.perform(get("/subject/listAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testListAll_Empty() throws Exception {
        Mockito.when(subjectService.listAll()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/subject/listAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data").isEmpty());
    }

    @Test
    public void testList_Success() throws Exception {
        Mockito.when(subjectService.list(anyString(), anyInt(), anyInt())).thenReturn(Collections.singletonList(new CmsSubject()));
        mockMvc.perform(get("/subject/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }
}
