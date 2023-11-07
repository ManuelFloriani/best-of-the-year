package org.java.lessons.springboot.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.Year;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index(Model model){
        //prendo l'anno corrente
        int year = Year.now().getValue();
        // prendo il mio nome
        String name = "Manuel";
        // li assegno a degli attributi
        model.addAttribute("currentYear", year);
        model.addAttribute("myName", name);
        return "home";
    }
}
