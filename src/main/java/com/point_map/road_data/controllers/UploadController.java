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
        saveData(jsonData);
        return "";
    }

    private void saveData(HashMap<String, String>  jsonData) throws Exception{
        String lat = jsonData.get("lat");
        String lng = jsonData.get("lng");
        LocalDate date = LocalDate.parse(jsonData.get("date"));
        String address = jsonData.get("address");
        String imageJson = jsonData.get("image");

        Point point = new Point(lat, lng, date, address);
        pointRepository.save(point);

        Point data = pointRepository.findByLatAndLng(lat, lng);
        String[] imagePath = saveImage(data.getId(), imageJson);

        data.setImage_path(imagePath[0]);
        pointRepository.save(data);

        // NN
//        String command = "python3 /Users/andrey/IdeaProjects/backend/NN/yolov5/detect.py " +
//                "--weights weights/IMSC/last_95_448_32_aug2.pt weights/IMSC/last_95_640_16.pt " +
//                "weights/IMSC/last_120_640_32_aug2.pt --img 640 --source " + imagePath[1] +
//                "--conf-thres 0.22 --iou-thres 0.9999 --agnostic-nms --augment\n";
//        Process p = Runtime.getRuntime().exec(command);

    }

    private String[] saveImage(long id, String imageJson) throws Exception{
        String[] imagePath = new String[2];
        imagePath[0] = "/images/" + id + "noNN.jpg";
        imagePath[1] = "/Users/andrey/IdeaProjects/backend/NN/yolov5/datasets" + id + "NN.jpg";

        FileOutputStream image = new FileOutputStream(imagePath[1]);
        byte[] imageByteArray = Base64.getDecoder().decode(imageJson);
        image.write(imageByteArray);

        return imagePath;
    }
 }
