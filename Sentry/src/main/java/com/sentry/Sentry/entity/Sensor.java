package com.sentry.Sentry.entity;

import javax.persistence.*;

@Entity
@Table(name = "sensor")
public class Sensor {
    //define fields
    @Id
    
    @Column(name = "SENSOR_ID")
    private int sensor_id;

    @Column(name = "SENSOR_TYPE")
    private String sensor_type;

    @Column(name = "SENSOR_NAME")
    private String sensor_name;
    
    @Column(name = "SENSOR_UNITS")
    private String sensor_units;

    @Column(name = "FK_ROOM_ID")
    private int fk_room_id;

    //constructors
    public Sensor(){

    }

    public Sensor(int sensor_id, String sensor_type, String sensor_name, String sensor_units, int  fk_room_id) {
        this.sensor_id = sensor_id;
        this.sensor_type =  sensor_type;
        this.sensor_name =  sensor_name;
        this.sensor_units = sensor_units;
        this.fk_room_id=  fk_room_id;
    
    }


  
    //getter/setter

    public int getId() {
        return sensor_id;
    }

    public void setId(int sensor_id) {
        this.sensor_id = sensor_id;
    }
    public String getSensorType() {
        return sensor_type;
    }

    public void setSensorType(String sensor_type) {
        this.sensor_type = sensor_type;
    }
    public String getSensorName() {
        return sensor_name;
    }

    public void setSensorName(String sensor_name) {
        this.sensor_name = sensor_name;
    }

    public String getSensorUnits() {
        return sensor_units;
    }

    public void setSensorUnits(String sensor_units) {
        this.sensor_units = sensor_units;
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
        return "Sensor{" + "sensor_id" + sensor_id +
                "sensor_type=" + sensor_type +
                ", sensor_name='" + sensor_name + '\'' +
                ", sensor_units='" + sensor_units + '\'' +
                ", fk_room_id='" + fk_room_id + '\''+
                '}';
    }
}
