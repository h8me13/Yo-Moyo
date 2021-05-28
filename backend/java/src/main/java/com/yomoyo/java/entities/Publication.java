package com.yomoyo.java.entities;

import javax.persistence.*;

@Entity
@Table(name="publication")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpublication;

    @Column(name="heading", nullable = false)
    private String heading;

    @Column(name="text", nullable = false)
    private String text;

    @Column(name="image",nullable = false)
    private  String image;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "creater_idcreater")
    private Creater creater;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "category_idcategory")
    private Category category;

    public Publication() {
    }

    public Publication(Long idpublication) {
        this.idpublication = idpublication;
    }

    public Publication(Long idpublication, String heading) {
        this.idpublication = idpublication;
        this.heading = heading;
    }

    public Publication(Long idpublication, String heading, String text) {
        this.idpublication = idpublication;
        this.heading = heading;
        this.text = text;
    }

    public Publication(Long idpublication, String heading, String text, String image) {
        this.idpublication = idpublication;
        this.heading = heading;
        this.text = text;
        this.image = image;
    }

    public Publication(String heading, String text, String image, Creater creater, Category category) {
        this.heading = heading;
        this.text = text;
        this.image = image;
        this.creater = creater;
        this.category = category;
    }

    public Publication(Long idpublication, String heading, String text, String image, Creater creater, Category category) {
        this.idpublication = idpublication;
        this.heading = heading;
        this.text = text;
        this.image = image;
        this.creater = creater;
        this.category = category;
    }

    public Long getIdpublication() {
        return idpublication;
    }

    public void setIdpublication(Long idpublication) {
        this.idpublication = idpublication;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Creater getCreater() {
        return creater;
    }

    public void setCreater(Creater creater) {
        this.creater = creater;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
