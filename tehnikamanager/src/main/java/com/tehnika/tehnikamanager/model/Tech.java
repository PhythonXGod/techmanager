package com.tehnika.tehnikamanager.model;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


// Tehnikas dati kurus vares dzest, mainit utt.
// Lidz galam nezinu ko dara visi sitie @ sudi, bet, ka es sapratu vini ir vajadzigi, lai vieglak savienotu visu.
@Entity
public class Tech implements Serializable {
    // Id izveide izmantojot @ sudus.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String properties;
    private String description;
    private LocalDate regtime;
    @Column(nullable = false, updatable = false)
    private String techCode;
    // getteri setteri konstruktori
    public Tech() {}
    public Tech(String name, String properties, String description, LocalDate regtime, String techCode) {
        this.name = name;
        this.properties = properties;
        this.description = description;
        this.regtime = regtime;
        this.techCode = techCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties() {
        this.properties = properties;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        this.description = description;
    }

    public LocalDate getRegtime() {
        return regtime;
    }

    public void setRegtime() { this.regtime = regtime; }

    public String getTechCode() {
        return techCode;
    }

    public void setTechCode(String techCode) {this.techCode = techCode;}


//?
    @Override
    public String toString() {
        return "Tech{" +
                "id=" + id +
                ", name'" + name + '\'' +
                ", properties'" + properties + '\'' +
                ", description'" + description + '\'' +
                ", regtime'" + regtime + '\'' +
                '}';
    }
}
