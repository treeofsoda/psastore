package com.psa.psastore.controller;

import com.psa.psastore.service.CmsPrefrenceAreaService;
import com.psa.psastore.model.CmsPrefrenceArea;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CmsPrefrenceAreaController.class)
public class CmsPrefrenceAreaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CmsPrefrenceAreaService prefrenceAreaService;

    @Test
    public void testListAll_Success() throws Exception {
        Mockito.when(prefrenceAreaService.listAll()).thenReturn(Collections.singletonList(new CmsPrefrenceArea()));
        mockMvc.perform(get("/prefrenceArea/listAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testListAll_Empty() throws Exception {
        Mockito.when(prefrenceAreaService.listAll()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/prefrenceArea/listAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data").isEmpty());
    }
}
