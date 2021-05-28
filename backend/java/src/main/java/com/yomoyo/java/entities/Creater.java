package com.yomoyo.java.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="creater")
public class Creater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcreater;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "user_iduser")
    private User user;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "creater")
    private List<Publication> publicationList;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "creater")
    private List<Sub> SubList;



    public Creater(Long idcreater) {
        this.idcreater = idcreater;
    }

    public Creater() {
    }
    public Creater(Long idcreater, User user)
    {
        this.idcreater = idcreater;
        this.user = user;
    }

    public Creater(Long idcreater, User user, List<Publication> publicationList) {
        this.idcreater = idcreater;
        this.user = user;
        this.publicationList = publicationList;
    }

    public Creater(Long idcreater, User user, List<Publication> publicationList, List<Sub> subList) {
        this.idcreater = idcreater;
        this.user = user;
        this.publicationList = publicationList;
        this.SubList = subList;
    }

    public Long getIdcreater() {
        return idcreater;
    }

    public void setIdcreater(Long idcreater) {
        this.idcreater = idcreater;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public void setPublicationList(List<Publication> publicationList) {
        this.publicationList = publicationList;
    }

    public void setSubList(List<Sub> subList) {
        SubList = subList;
    }
}
