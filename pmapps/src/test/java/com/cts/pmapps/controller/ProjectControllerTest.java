package com.cts.pmapps.controller;

import com.cts.pmapps.domain.Project;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ProjectControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getProjectDetailsTest() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/projects").accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void getProjectNamesTest() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/allprojects").accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }
    @Test
    public void getProjectByIdTest() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/projects/1").accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }



}
