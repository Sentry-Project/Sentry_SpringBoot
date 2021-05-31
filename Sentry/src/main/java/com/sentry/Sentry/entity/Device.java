package com.sentry.Sentry.entity;

import javax.persistence.*;

@Entity
@Table(name = "device")
public class Device {
    //define fields
    @Id

    @Column(name = "DEVICE_ID")
    private int device_id;

    @Column(name = "DEVICE_NAME")
    private String device_name;

    @Column(name = "DEVICE_STATUS")
    private int device_status;

    @Column(name = "FK_ROOM_ID")
    private int fk_room_id;

    //constructors
    public Device(){

    }

    public Device(String device_name,  int  fk_room_id) {
        this.device_name = device_name;
        this.fk_room_id=  fk_room_id;

    }

    public Device(int device_id, String device_name, int device_status, int  fk_room_id) {
        this.device_id = device_id;
        this.device_name = device_name;
        this.device_status = device_status;
        this.fk_room_id=  fk_room_id;

    }



    //getter/setter

    public int getId() {
        return device_id;
    }

    public void setId(int device_id) {
        this.device_id = device_id;
    }

    public String getDeviceName() {
        return device_name;
    }

    public void setDeviceName(String device_name) {
        this.device_name = device_name;
    }

    public int getDeviceStatus() {
        return device_status;
    }

    public void setDeviceStatus(int device_status) {
        this.device_status = device_status;
    }

    public int getFKRoomID() {
        return fk_room_id;
    }

    public void setFKRoomID(int fk_room_id) {
        this.fk_room_id = fk_room_id;
    }



    //toString

    @Override
    public String toString() {
        return "Device{" +
                "device_id=" + device_id +
                ", device_name='" + device_name + '\'' +
                ", device_status='" + device_status + '\'' +
                ", fk_room_id='" + fk_room_id + '\''+
                '}';
    }
}
