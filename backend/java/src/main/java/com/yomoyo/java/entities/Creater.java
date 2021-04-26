package com.yomoyo.java.entities;

import javax.persistence.*;

@Entity
@Table(name="creater")
public class Creater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcreater;

    public Creater(Long idcreater) {
        this.idcreater = idcreater;
    }

    public Creater() {
    }

    public Long getIdcreater() {
        return idcreater;
    }

    public void setIdcreater(Long idcreater) {
        this.idcreater = idcreater;
    }
}
