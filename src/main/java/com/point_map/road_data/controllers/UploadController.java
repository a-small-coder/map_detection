package com.point_map.road_data.controllers;

import com.point_map.road_data.models.Point;
import com.point_map.road_data.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.*;


@Controller
public class UploadController {
    @Autowired
    PointRepository pointRepository;

    @PostMapping("/upload")
    @ResponseBody
    public String postUpload(@RequestBody(required=false) HashMap<String, String> jsonData) throws Exception {
//        System.out.println(jsonData);
        saveData(jsonData);

        // вызов модуля nn, передача пути к изображению, id в БД


        return "";
    }

    private void saveData(HashMap<String, String>  jsonData) throws Exception{
        System.out.println(jsonData);
        String lat = jsonData.get("lat");
        String lng = jsonData.get("lng");
        LocalDate date = LocalDate.parse(jsonData.get("date"));
        String address = jsonData.get("address");
        String imageJson = jsonData.get("image");

        Point point = new Point(lat, lng, date, address);
        pointRepository.save(point);

        // --------------------------save image----------------------------------------
        Point data = pointRepository.findByLatAndLng(lat, lng);

        String imagePath = saveImage(data.getId(), imageJson);

        FileOutputStream image = new FileOutputStream("/Users/andrey/IdeaProjects/backend/src/main/resources/" +
                "static/images/" + data.getId() + "noNN.jpg");
        byte[] imageByteArray = Base64.getDecoder().decode(jsonData.get("image"));
        image.write(imageByteArray);
        // -------------------------------

//        pointRepository.up;
    }

    private String saveImage(long id, String imageJson) throws Exception{

        String imagePath = "/images/" + id + "noNN.jpg";

        FileOutputStream image = new FileOutputStream("/Users/andrey/IdeaProjects/backend/src/main/resources/" +
                "static/images/" + id + "noNN.jpg");
        byte[] imageByteArray = Base64.getDecoder().decode(imageJson);
        image.write(imageByteArray);
        return imagePath;
    }
 }
