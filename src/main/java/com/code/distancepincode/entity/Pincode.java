package com.code.distancepincode.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
    @Table(name = "pincode")
    public class Pincode {
        @Id
        private String pincode;

        private double latitude;
        private double longitude;
        private String polygon; // You can use a more complex type if needed

    public Pincode() {

    }

    public Pincode(String pincode, double latitude, double longitude, String polygon) {
        this.pincode = pincode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.polygon = polygon;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPolygon() {
        return polygon;
    }

    public void setPolygon(String polygon) {
        this.polygon = polygon;
    }
}

