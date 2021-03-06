package com.point_map.road_data.repository;

import com.point_map.road_data.models.Point;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PointRepository extends CrudRepository<Point, Long> {
    Point findByLatAndLng(String lat, String lng);
    Iterable<Point> findByOrderByDate();
}
