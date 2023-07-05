package com.sss.talakona.Room;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Talakona {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String vehicleNo;
    private String name;
    private String phone;
    private String city;

    public Talakona(int id, String vehicleNo, String name, String phone, String city, String noofPersons, String twoWhlrCount, String threeWhlrCount, String fourWhlrCount, String busTruckCount, String stillCameraCount, String videoCameraCount, String totalCost) {
        this.id = id;
        this.vehicleNo = vehicleNo;
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.noofPersons = noofPersons;
        this.twoWhlrCount = twoWhlrCount;
        this.threeWhlrCount = threeWhlrCount;
        this.fourWhlrCount = fourWhlrCount;
        this.busTruckCount = busTruckCount;
        this.stillCameraCount = stillCameraCount;
        this.videoCameraCount = videoCameraCount;
        this.totalCost = totalCost;
    }

    private String noofPersons;
    private String twoWhlrCount;
    private String threeWhlrCount;
    private String fourWhlrCount;
    private String busTruckCount;
    private String stillCameraCount;
    private String videoCameraCount;
    private String totalCost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNoofPersons() {
        return noofPersons;
    }

    public void setNoofPersons(String noofPersons) {
        this.noofPersons = noofPersons;
    }

    public String getTwoWhlrCount() {
        return twoWhlrCount;
    }

    public void setTwoWhlrCount(String twoWhlrCount) {
        this.twoWhlrCount = twoWhlrCount;
    }

    public String getThreeWhlrCount() {
        return threeWhlrCount;
    }

    public void setThreeWhlrCount(String threeWhlrCount) {
        this.threeWhlrCount = threeWhlrCount;
    }

    public String getFourWhlrCount() {
        return fourWhlrCount;
    }

    public void setFourWhlrCount(String fourWhlrCount) {
        this.fourWhlrCount = fourWhlrCount;
    }

    public String getBusTruckCount() {
        return busTruckCount;
    }

    public void setBusTruckCount(String busTruckCount) {
        this.busTruckCount = busTruckCount;
    }

    public String getStillCameraCount() {
        return stillCameraCount;
    }

    public void setStillCameraCount(String stillCameraCount) {
        this.stillCameraCount = stillCameraCount;
    }

    public String getVideoCameraCount() {
        return videoCameraCount;
    }

    public void setVideoCameraCount(String videoCameraCount) {
        this.videoCameraCount = videoCameraCount;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }






}
