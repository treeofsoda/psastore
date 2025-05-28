package com.psa.psastore.controller;

import com.psa.psastore.service.PmsBrandService;
import com.psa.psastore.model.PmsBrand;
import com.psa.psastore.dto.PmsBrandParam;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
// Removed unused import
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PmsBrandController.class)
public class PmsBrandControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PmsBrandService brandService;

    @Test
    public void testListAll_Success() throws Exception {
        Mockito.when(brandService.listAllBrand()).thenReturn(Collections.singletonList(new PmsBrand()));
        mockMvc.perform(get("/brand/listAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testListAll_Empty() throws Exception {
        Mockito.when(brandService.listAllBrand()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/brand/listAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data").isEmpty());
    }

    @Test
    public void testCreate_Failed() throws Exception {
        Mockito.when(brandService.createBrand(any(PmsBrandParam.class))).thenReturn(0);
        mockMvc.perform(post("/brand/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(500));
    }
}
