package com.point_map.road_data.controllers;

import com.point_map.road_data.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @PostMapping
    public String click(){
        System.out.println("fbjsh");
        return "redirect:/table";
    }
    @GetMapping
    public String rootPage(User user){
            return "redirect:/worker";
        }
}
