package com.csti.intercopretail.microservice3.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "root")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Root {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")

    private Person person;

    private int random;

    @Column(name = "random_float")
    private float randomFloat;

    private boolean bool;

    private String date;
    @Column(name = "regEx")
    private String regEx;

    @Column(name = "enum")
    private String enumValue;

     @ElementCollection
    @CollectionTable(name = "elt", joinColumns = @JoinColumn(name = "root_id"))
    @Column(name = "elt")
    private List<String> elt;

    @Column(name = "LAST_UPDATE")
    private String lastUpdate;

    public void setPerson(Person person) {
        this.person = person;
        setLastModifiedToCurrentDateTime();
    }
    private void setLastModifiedToCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        this.lastUpdate = sdf.format(new Date());
    }
}
