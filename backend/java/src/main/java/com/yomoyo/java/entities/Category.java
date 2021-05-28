package com.yomoyo.java.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcategory;

    @Column(name="ctgname", nullable = false)
    private String ctgname;

    @Column(name="description", nullable = false)
    private String description;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "category")
    private List<Publication> publicationListCat;

    public Category() {
    }

    public Category(Long idcategory) {
        this.idcategory = idcategory;
    }

    public Category(Long idcategory, String ctgname) {
        this.idcategory = idcategory;
        this.ctgname = ctgname;
    }

    public Category(Long idcategory, String ctgname, String description) {
        this.idcategory = idcategory;
        this.ctgname = ctgname;
        this.description = description;
    }

    public Category(Long idcategory, String ctgname, String description, List<Publication> publicationListCat) {
        this.idcategory = idcategory;
        this.ctgname = ctgname;
        this.description = description;
        this.publicationListCat = publicationListCat;
    }

    public Long getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Long idcategory) {
        this.idcategory = idcategory;
    }

    public String getCtgname() {
        return ctgname;
    }

    public void setCtgname(String ctgname) {
        this.ctgname = ctgname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublicationListCat(List<Publication> publicationListCat) {
        this.publicationListCat = publicationListCat;
    }
}

