package com.point_map.road_data.controllers;

import com.point_map.road_data.models.Point;
import com.point_map.road_data.repository.PointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private PointRepository pointRepository;

    @GetMapping("/")
    public String table(Model model) {
        Iterable<Point> data = pointRepository.findByOrderByDate();
        model.addAttribute("points", data);
        return "table";
    }
}
