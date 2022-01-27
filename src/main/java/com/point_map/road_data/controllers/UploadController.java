package com.point_map.road_data.controllers;

import com.point_map.road_data.models.Point;
import com.point_map.road_data.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Controller
public class UploadController {
    @Autowired
    PointRepository pointRepository;


    @PostMapping("/upload")
    @ResponseBody
    public String postUpload(@RequestBody(required=false) String jsonData){
        String data[] = jsonData.split("&");
        String lat = data[0].replace("lat=", "");
        String lng = data[1].replace("lng=", "");
        String strDate = data[2].replace("date=", "");
        LocalDate date = LocalDate.parse(strDate);
        String address = data[3].replace("address=", "");
        Point point = new Point(lat, lng, "яма", date, "5x5", address,
                "/Users/andrey/IdeaProjects/backend/src/main/resources/static/images/test.jpg",
                "Иванов");
        pointRepository.save(point);
        return "";
    }
}
