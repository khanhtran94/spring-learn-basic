package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Site {
    private Integer id;
    private String name;
    private double latitude;
    private double longitude;

    public Site(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Site() {
    }
}
