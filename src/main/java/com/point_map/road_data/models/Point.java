package com.point_map.road_data.models;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "point")
public class Point {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String lat;

        @Column
        private String lng;

        @Column
        private String type;

        @Column
        private LocalDate date;

        @Column
        private String size;

        @Column
        private String address;

        @Column
        private String image_path;

        @Column
        private String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getImage_path() {
            return image_path;
        }

        public void setImage_path(String image_path) {
            this.image_path = image_path;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) { this.name = name; }

    public Point() {
    }

    public Point (String lat, String lng, LocalDate date,String address) {
        this.lat = lat;
        this.lng = lng;
        this.date = date;
        this.address = address;
    }

    public Point (String lat, String lng, LocalDate date,String address, String image_path) {
        this.lat = lat;
        this.lng = lng;
        this.date = date;
        this.address = address;
        this.image_path = image_path;
    }

    public Point(String lat, String lng, String type, LocalDate date, String size, String address, String image_path,
                 String name) {
        this.lat = lat;
        this.lng = lng;
        this.type = type;
        this.date = date;
        this.size = size;
        this.address = address;
        this.image_path = image_path;
        this.name = name;
    }
}

