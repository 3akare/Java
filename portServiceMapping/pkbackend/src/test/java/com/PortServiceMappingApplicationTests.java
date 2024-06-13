package com;

import com.PortServiceMappingClassSetup.PortServiceMappingClassSetup;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayNameGeneration(value = DisplayNameGenerator.Standard.class)
@AutoConfigureMockMvc
public class PortServiceMappingApplicationTests extends PortServiceMappingClassSetup {
    @Test
    void contextLoads() {
    }
    private final MockMvc mockMvc;

    @Autowired
    public PortServiceMappingApplicationTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void activeProfileTest() throws Exception {
        String defaultText = """
                {
                "Message": "Welcome to PORTKEEPER App ...local dev Api",
                "contactDetails": {
                "name": "DAVID BAKARE - DB"
                },
                "onCallSupport": [
                "+(234)8 159 602 684"
                ]
                }""";
        ResultActions resultActions = mockMvc.perform(get("/propertyFile"));
        resultActions.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(defaultText));
    }

    @Test
    public void defaultEndpoint() throws Exception{
        ResultActions resultActions = mockMvc.perform(get("/"));
        resultActions.andExpect(status().isNotFound());
    }
}




