package com.yomoyo.java.entities;

import javax.persistence.*;

@Entity
@Table(name="sub")
public class Sub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsub;

    public Sub() {
    }

    public Sub(Long idsub) {
        this.idsub = idsub;
    }

    public Long getIdsub() {
        return idsub;
    }

    public void setIdsub(Long idsub) {
        this.idsub = idsub;
    }
}
