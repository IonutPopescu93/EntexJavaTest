package com.entex.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class County {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column (unique = true)
    private Long id;
    @Column (name = "id_county", unique = true)
    private Long idCounty;

    private String countyName;
    private String countyCode;
    @OneToMany(mappedBy = "countyCode")
    private List<Locality> localities;
}
