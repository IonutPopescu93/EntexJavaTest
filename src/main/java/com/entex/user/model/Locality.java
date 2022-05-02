package com.entex.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
public class Locality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id", unique = true)
    private Long id;
    private String localityName;
    @ManyToOne
    @JoinColumn (name = "countyCode")
    private County countyCode;


}
