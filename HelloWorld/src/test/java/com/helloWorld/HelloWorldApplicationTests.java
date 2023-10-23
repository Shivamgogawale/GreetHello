package com.helloWorld;


import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.helloWorld.controller.HelloWorldController;

@ExtendWith(MockitoExtension.class)
public class HelloWorldApplicationTests {

    @InjectMocks
    private HelloWorldController helloController;

    @Mock
    private HttpServletRequest request;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
    }

    @Test
    public void testGetHelloWithParameter() throws Exception {
        String name = "Alice";
        String expectedResponse = "hello " + name + " !!!";

        mockMvc.perform(MockMvcRequestBuilders.get("/greetapi/v1/hello").param("name", name))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string(expectedResponse));
    }

    @Test
    public void testGetHelloWithoutParameter() throws Exception {
        String expectedResponse = "hello World !!!";

        mockMvc.perform(MockMvcRequestBuilders.get("/greetapi/v1/hello"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string(expectedResponse));
    }
}
