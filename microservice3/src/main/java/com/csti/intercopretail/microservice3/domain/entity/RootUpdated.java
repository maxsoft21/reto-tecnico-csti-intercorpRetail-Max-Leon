package com.csti.intercopretail.microservice3.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "root_updated")
@Getter
@Setter
@AllArgsConstructor
public class RootUpdated {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")

    private PersonUpdated person;
    private int random;

    @Column(name = "randomFloat")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonUpdated getPerson() {
        return person;
    }

    public void setPerson(PersonUpdated person) {
        this.person = person;
        setLastModifiedToCurrentDateTime();
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public float getRandomFloat() {
        return randomFloat;
    }

    public void setRandomFloat(float randomFloat) {
        this.randomFloat = randomFloat;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRegEx() {
        return regEx;
    }

    public void setRegEx(String regEx) {
        this.regEx = regEx;
    }

    public String getEnumValue() {
        return enumValue;
    }

    public void setEnumValue(String enumValue) {
        this.enumValue = enumValue;
    }

    public List<String> getElt() {
        return elt;
    }

    public void setElt(List<String> elt) {
        this.elt = elt;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    private void setLastModifiedToCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        this.lastModified = sdf.format(new Date());
    }
}
