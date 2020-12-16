package com.abc.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class User {
   private int id;
   private String username;
   private String password;
   private int pri;

//    public User(String username, String password, int pri) {
//        this.username = username;
//        this.password = password;
//        this.pri = pri;
//    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, int pri) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.pri = pri;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
