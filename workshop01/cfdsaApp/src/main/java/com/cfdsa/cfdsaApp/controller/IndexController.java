package com.cfdsa.cfdsaApp.controller;


import com.cfdsa.cfdsaApp.service.RandomTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private RandomTextService randomTextService;

    @GetMapping("/")
    public String index(Model model) {
        String message = randomTextService.getRandText();
        model.addAttribute("message", message);
        System.out.println("Controller called");
        return "index";
    }
}
