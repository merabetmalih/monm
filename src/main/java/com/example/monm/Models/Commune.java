package com.example.monm.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "communes")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Commune {

    @Id
    @Column(name = "codeinsee")
    private int codeInsee;

    @Column(name = "nom")
    private String name;

    @OneToOne(mappedBy = "commune")
    @JsonBackReference
    private Monument monument;



}

