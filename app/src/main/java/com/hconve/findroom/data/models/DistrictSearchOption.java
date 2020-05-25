package com.hconve.findroom.data.models;

public class DistrictSearchOption {
    public int id;
    public String name;
    public String location;
    public int provinceId;

    public DistrictSearchOption(int id, String name, String location, int provinceId) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.provinceId = provinceId;
    }
}
