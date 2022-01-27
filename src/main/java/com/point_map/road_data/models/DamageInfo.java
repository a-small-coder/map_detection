package com.point_map.road_data.models;

public class DamageInfo {
    private String[] data = new String[4];
    private String image = new String();

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
