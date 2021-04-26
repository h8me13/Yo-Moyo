package com.yomoyo.java.entities;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="surname", nullable = false)
    private String surname;

    @Column(name="login", nullable = false)
    private String login;

    @Column(name="password", nullable = false)
    private String password;

    public User(Long iduser) {
        this.iduser = iduser;
    }

    public User(Long iduser, String name) {
        this.iduser = iduser;
        this.name = name;
    }

    public User(Long iduser, String name, String surname) {
        this.iduser = iduser;
        this.name = name;
        this.surname = surname;
    }

    public User(Long iduser, String name, String login, String password) {
        this.iduser = iduser;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(Long iduser, String name, String surname, String login, String password) {
        this.iduser = iduser;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIduser(Long id) {
        this.iduser = id;
    }

    public Long getIduser() {
        return iduser;
    }
}
