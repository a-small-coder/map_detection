package com.point_map.road_data.repository;

import com.point_map.road_data.models.Road_detection_db;
import org.springframework.data.repository.CrudRepository;


public interface PointRepository extends CrudRepository<Road_detection_db, Long> {
}
