package com.point_map.road_data.repository;

import com.point_map.road_data.models.Point;
import org.springframework.data.repository.CrudRepository;


public interface PointRepository extends CrudRepository<Point, Long> {
}
