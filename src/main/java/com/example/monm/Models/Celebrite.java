package com.example.monm.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;



@Entity @Table(name = "Celebrite")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Celebrite {

    @Transient
    protected boolean isNew=false;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    public boolean isNew() {
        return isNew;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }





    public List<Monument> getListMonument() {
        return listMonument;
    }

    public void setListMonument(List<Monument> listMonument) {
        this.listMonument = listMonument;
    }

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nationalite")
    private String nationalite;

    @Column(name = "epoque")
    private String epoque;

    @ManyToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)//mappedBy = "listCelebrite")
    @JsonBackReference
    @JoinTable( name = "AssocieA",
            joinColumns = @JoinColumn( name = "numCelebrite", insertable = true, updatable = true, nullable=false ),
            inverseJoinColumns = @JoinColumn( name = "codeM" ) )
    private List<Monument> listMonument;


}
