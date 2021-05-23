package com.sentry.Sentry.entity;
import java.util.List;

import javax.persistence.CascadeType;
//
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//
//
@Entity
@Table(name = "room")
public class Room{
    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID")
    private int rid;

    @Column(name = "ROOM_NAME")
    private String rname;
    
    @Column(name = "FK_USER_ID")
    private int user_id;

   
  /* @ManyToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumn(name = "FK_USER_ID", nullable = false)
   private User user;*/
   
 /* @OneToMany(mappedBy = "room", fetch = FetchType.LAZY,
           cascade = CascadeType.ALL)
   private List<Sensor> sensors;*/
   


    //constructors
    public Room(){

    }

    public Room(int rid, String rname, int user_id) {
        this.rid = rid;
        this.rname = rname;
        this.user_id = user_id;

    }
    
    public Room(String rname, int user_id) {
        this.rname = rname;
        this.user_id = user_id;

    }
    /*public Room(List<Sensor> sensors) {
        this.sensors = sensors;

    }*/
    
    
   /* public Room(String rname, int user_id) {
        this.rname = rname;
        this.user_id = user_id;
    }*/

    public int getRId() {
        return rid;
    }

    public void setRId(int rid) {
        this.rid = rid;
    }

    public String getrname() {
        return rname;
    }

    public void setrname(String rname) {
        this.rname = rname;
    }
    
    public int getuser_id() {
		return user_id;
	}

	public void setuser_id(int user_id) {
		this.user_id = user_id;
	}
	
	/*public List<Sensor> getsensor() {
		return sensors;
	}

	public void setsensor(List<Sensor> sensors) {
		this.sensors = sensors;
	}*/
	
	/*
    public User getuser() {
		return user;
	}

	public void setuser(User user) {
		this.user = user;
	}*/


    @Override
    public String toString() {
		 return "Room{" +
         "rid=" + rid +
         ", rname='" + rname + '\'' +
         '}';
   }


}
