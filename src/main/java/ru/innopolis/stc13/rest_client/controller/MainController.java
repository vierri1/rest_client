package ru.innopolis.stc13.rest_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc13.rest_client.dto.Request;
import ru.innopolis.stc13.rest_client.dto.Response;
import ru.innopolis.stc13.rest_client.service.ResponseService;

@Controller
public class MainController {

    @Autowired
    ResponseService responseService;

    @PostMapping("/check")
    public String restWithParam(@ModelAttribute Request request, Model model) {
        Response response = responseService.getResponse(request);
        model.addAttribute("response", response);
        return "response";
    }

    @GetMapping("/check")
    public String showCheckPage() {
        return "check";
    }
}