package com;

import com.PortServiceMappingClassSetup.PortServiceMappingClassSetup;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Random;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@DisplayNameGeneration(value = DisplayNameGenerator.Standard.class)
public class PortServiceMappingControllerTest extends PortServiceMappingClassSetup {

    private final MockMvc mockMvc;
    Random random = new Random();
    String portNumber = String.format("%04d", random.nextInt(10000));

    @Autowired
    public PortServiceMappingControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

//    @BeforeAll

    @Test
    public void getPortsTest() throws Exception {
        mockMvc.perform(get("/api/v1/port"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void postPortsTestAlreadyExists() throws Exception {
        String jsonData = "{" +
                "\"servicePortNumber\":\"1234\"," +
                "\"associateService\":\"testingwithmockmvc.com\"," +
                "\"serviceIpAddress\":\"testingwithmockmvc.com\"," +
                "\"javaVersion\":\"17\"" +
                "}";
        mockMvc.perform(post("/api/v1/port")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonData));

        mockMvc.perform(post("/api/v1/port")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonData))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void postPortsTestNotExists() throws Exception {
        String jsonData = "{" +
                "\"servicePortNumber\":"+
                "\"" + portNumber + "\"" + "," +
                "\"associateService\":\"testingwithmockmvc.com\"," +
                "\"serviceIpAddress\":\"testingwithmockmvc.com\"," +
                "\"javaVersion\":\"17\"" +
                "}";
        mockMvc.perform(post("/api/v1/port")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonData))
                .andExpect(status().isOk());
    }

    @Test
    public void putPortsTestExists() throws Exception{
        String jsonData = "{" +
                "\"servicePortNumber\":\"1234\"," +
                "\"associateService\":\"testingwithmockmvc-updated.com\"," +
                "\"serviceIpAddress\":\"testingwithmockmvc-updated.com\"," +
                "\"javaVersion\":\"17\"" +
                "}";

        mockMvc.perform(put("/api/v1/port?servicePortNumber=1234&serviceIpAddress=testingwithmockmvc-updated.com")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonData))
                .andExpect(status().is5xxServerError());
    }

    @Test
    public void putPortsTestNotExists() throws Exception{
        String jsonData = "{" +
                "\"servicePortNumber\":"+
                "\"" + portNumber + "\"" + "," +
                "\"associateService\":\"testingwithmockmvc-updated.com\"," +
                "\"serviceIpAddress\":\"testingwithmockmvc-updated.com\"," +
                "\"javaVersion\":\"17\"" +
                "}";

        mockMvc.perform(put("/api/v1/port")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonData))
                .andExpect(status().is5xxServerError());
    }

    @Test
    public void deletePortsTestExists() throws Exception{
        String jsonData = "{" +
                "\"servicePortNumber\":\"1234\"," +
                "\"associateService\":\"testingwithmockmvc-updated.com\"," +
                "\"serviceIpAddress\":\"testingwithmockmvc-updated.com\"," +
                "\"javaVersion\":\"17\"" +
                "}";

        mockMvc.perform(delete("/api/v1/port?servicePortNumber=1234&serviceIpAddress=testingwithmockmvc-updated.com")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonData))
                .andExpect(status().is5xxServerError());
    }

    @Test
    public void deletePortsTestNotExists() throws Exception{
        String jsonData = "{" +
                "\"servicePortNumber\":"+
                "\"" + portNumber + "\"" + "," +
                "\"associateService\":\"testingwithmockmvc-updated.com\"," +
                "\"serviceIpAddress\":\"testingwithmockmvc-updated.com\"," +
                "\"javaVersion\":\"17\"" +
                "}";

        mockMvc.perform(delete("/api/v1/port")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonData))
                .andExpect(status().is5xxServerError());
    }

}
