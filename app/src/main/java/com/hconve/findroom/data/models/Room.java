package com.hconve.findroom.data.models;

public class Room {
    public int backgroundColor;
    public String title;
    public String address;
    public long price;

    public Room(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        this.title = "Phòng trọ";
        this.address = "Phạm Ngũ Lão, Quận 1";
        this.price = 1000000L;
    }
}
