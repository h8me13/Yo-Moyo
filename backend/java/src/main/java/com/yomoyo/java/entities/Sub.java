package com.yomoyo.java.entities;

import javax.persistence.*;

@Entity
@Table(name="sub")
public class Sub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsub;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "creater_idcreater")
    private Creater creater;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "user_iduser")
    private User user;

    public Sub() {
    }

    public Sub(Long idsub) {
        this.idsub = idsub;
    }

    public Sub(Long idsub, Creater creater) {
        this.idsub = idsub;
        this.creater = creater;
    }

    public Sub(Long idsub, Creater creater, User user) {
        this.idsub = idsub;
        this.creater = creater;
        this.user = user;
    }

    public Long getIdsub() {
        return idsub;
    }

    public void setIdsub(Long idsub) {
        this.idsub = idsub;
    }

    public Creater getCreater() {
        return creater;
    }

    public void setCreater(Creater creater) {
        this.creater = creater;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
