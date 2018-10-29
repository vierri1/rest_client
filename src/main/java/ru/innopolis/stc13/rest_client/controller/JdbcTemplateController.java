package ru.innopolis.stc13.rest_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import ru.innopolis.stc13.rest_client.dto.Request;
import ru.innopolis.stc13.rest_client.dto.Response;

@Controller
public class JdbcTemplateController {
    @Autowired
    RestTemplate restTemplate;

    final String ROOT_URI = "http://localhost:8080/param";

    @PostMapping("/checkTemplate")
    public @ResponseBody Response restWithParam(@ModelAttribute Request request, Model model) {
        ResponseEntity<Response> response = restTemplate.postForEntity(ROOT_URI, request, Response.class);
        return response.getBody();
    }
}
