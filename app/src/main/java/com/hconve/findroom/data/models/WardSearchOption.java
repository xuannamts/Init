package com.hconve.findroom.data.models;

public class WardSearchOption {
    public int id;
    public String name;
    public String location;
    public int districtId;

    public WardSearchOption(int id, String name, String location, int districtId) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.districtId = districtId;
    }
}
