package com.point_map.road_data.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {
    @GetMapping("/map")
    public String Map(Model model){
        return "map";
    }
}
