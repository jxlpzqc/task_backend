package com.hour.task.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User {
    @Column(nullable = true)
    String username;
    String password;
    String isAdmin;
    @Column(nullable = true)
    String wxsessionkey;
    String sessionkey;
    @Column(nullable = true)
    String openid;
    @Column(nullable = true)
    String smscode;
    @Column(nullable = true)
    String phonenum;
}
