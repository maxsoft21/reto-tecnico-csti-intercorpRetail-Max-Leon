package com.csti.intercopretail.microservice2.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "root_updated")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RootUpdated {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")

    private PersonUpdated person;
    private int random;

    @Column(name = "random_float")
    private float randomFloat;

    private boolean bool;

    private String date;

    private String regEx;

    @Column(name = "enum")
    private String enumValue;

    @ElementCollection
    private List<String> elt;

    @Column(name = "LAST_MODIFIED")
    private String lastModified;

    public PersonUpdated getPerson() {
        return person;
    }
    public void setRegEx(String regEx) {
        this.regEx = regEx;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    private void setLastModifiedToCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        this.lastModified = sdf.format(new Date());
    }
}
