package com.csti.intercopretail.microservice1.domain.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
    @XmlElement
    private Person person;

    @XmlElement
    private int random;

    @XmlElement(name = "random_float")
    private float randomFloat;

    @XmlElement
    private boolean bool;

    @XmlElement
    private String date;

    @XmlElement
    private String regEx;

    @XmlElement(name = "enum")
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

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    private void setLastModifiedToCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        this.lastUpdate = sdf.format(new Date());
    }
}
