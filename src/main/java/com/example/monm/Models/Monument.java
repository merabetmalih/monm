package com.example.monm.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "monument")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Monument {


    @Id
    @Column(name = "geohash")
    private String code;

    @Column(name = "nom")
    private String nom;

    @Column(name = "typeM")
    private String type;

    @Column(name = "proprietaire")
    private String proprietaire;

    @Column(name = "longitude")
    private float longitude;

    @Column(name = "latitude")
    private float latitude;


    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    //@JsonManagedReference
    @JoinTable( name = "AssocieA",
            joinColumns = @JoinColumn( name = "codeM" ),
            inverseJoinColumns = @JoinColumn( name = "numCelebrite" ) )
    private Set<Celebrite> listCelebrite;


    @OneToOne(fetch=FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "codeInsee", referencedColumnName = "codeInsee")
    private Commune commune;


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getProprietaire() {
        return proprietaire;
    }


    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }


    public float getLongitude() {
        return longitude;
    }


    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }


    public float getLatitude() {
        return latitude;
    }


    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }


    public Set<Celebrite> getListCelebrite() {
        return listCelebrite;
    }


    public void setListCelebrite(Set<Celebrite> listCelebrite) {
        this.listCelebrite = listCelebrite;
    }


    public Commune getCommune() {
        return commune;
    }


    public void setCommune(Commune commune) {
        this.commune = commune;
    }






}
