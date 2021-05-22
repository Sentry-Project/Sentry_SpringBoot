//package com.sentry.Sentry.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name = "room")
//public class Room {
//    //define fields
//    @Id
//    @Column(name = "ROOM_ID")
//    private int rid;
//
//    @Column(name = "ROOM_NAME")
//    private String rname;
//
//   @Column(name = "FK_USER_ID")
//    private int user_id;
//
//    //private User user;
//
//    //constructors
//    public Room(){
//
//    }
//
//    public Room(int rid, String rname, int user_id) {
//        this.rid = rid;
//        this.rname = rname;
//        this.user_id = user_id;
//    }
//    /*
//    public Room(String rname, int user_id) {
//        this.rname = rname;
//        this.user_id = user_id;
//    }*/
//
//    public int getRId() {
//        return rid;
//    }
//
//    public void setRId(int rid) {
//        this.rid = rid;
//    }
//
//    public String getrname() {
//        return rname;
//    }
//
//    public void setrname(String rname) {
//        this.rname = rname;
//    }
//
//    public int getuseid() {
//		return user_id;
//	}
//
//	public void setuserid(int user_id) {
//		this.user_id = user_id;
//	}
//    /*public User getuse() {
//		return user;
//	}
//
//	public void setuser(User user) {
//		this.user = user;
//	}*/
//
//    @Override
//    public String toString() {
//		 return "Room{" +
//         "rid=" + rid +
//         ", rname='" + rname + '\'' +
//         '}';
//   }
//
//}
