package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Roman on 13.07.2017.
 */

@Entity
@Table(name = "usersdata")
public class User {
    private long idUser;
    private String nikName;
    private String email;
    private String password;

    public User() {
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idUser")
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Column(name = "nikName")
    public String getNikName() {
        return nikName;
    }

    public void setNikName(String nikName) {
        this.nikName = nikName;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "passord")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
