package com.point_map.road_data.controllers;

import com.point_map.road_data.models.Point;
import com.point_map.road_data.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("hasAuthority('BRIGADIER')")
public class BrigadierController {
    @Autowired
    private PointRepository pointRepository;

    @GetMapping("/brigadier")
    public String table(Model model) {
        Iterable<Point> data = pointRepository.findByOrderByDate();
        model.addAttribute("points", data);
        return "brigadier";
    }
}
