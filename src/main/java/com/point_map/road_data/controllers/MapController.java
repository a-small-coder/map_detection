package com.point_map.road_data.controllers;

import com.point_map.road_data.models.Point;
import com.point_map.road_data.repository.PointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MapController {
    @Autowired
    private PointRepository pointRepository;

    @GetMapping("/map/{id}")
    public String map(@PathVariable(value = "id") long pointID, Model model){
        ArrayList<Point> pointData = getData(pointID);
        model.addAttribute("point_data1", pointData);
        model.addAttribute("point_data2", pointData);
        return "map";
    }

    @GetMapping("/map/all")
    public String mapAll(Model model){
        Iterable<Point> points = pointRepository.findAll();
        model.addAttribute("points", points);
        return "mapAll";
    }

    private ArrayList<Point> getData(long pointID){
        Optional<Point> point =  pointRepository.findById(pointID);
        ArrayList<Point> pointData = new ArrayList<>();
        point.ifPresent(pointData::add);
        return pointData;
    }
}
