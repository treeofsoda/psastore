package com.psa.psastore.controller;

import com.psa.psastore.service.PmsProductAttributeCategoryService;
import com.psa.psastore.model.PmsProductAttributeCategory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PmsProductAttributeCategoryController.class)
public class PmsProductAttributeCategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PmsProductAttributeCategoryService categoryService;

    @Test
    public void testListAll_Success() throws Exception {
        Mockito.when(categoryService.getList(anyInt(), anyInt())).thenReturn(Collections.singletonList(new PmsProductAttributeCategory()));
        mockMvc.perform(get("/productAttribute/category/listAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void testListAll_Empty() throws Exception {
        Mockito.when(categoryService.getList(anyInt(), anyInt())).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/productAttribute/category/listAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data").isEmpty());
    }
}
