package Enos.SpringProject.literAlura.models;

import Enos.SpringProject.literAlura.models.gutendex.PersonGutendex;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "persons")
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    protected String name;
    @Column(name = "birth_year")
    protected Integer birthYear;
    @Column(name = "detah_year")
    protected Integer deathYear;

    public Person(){}

    public Person(PersonGutendex personGutendex){
        this.name = personGutendex.name();
        this.birthYear = personGutendex.birthYear();
        this.deathYear = personGutendex.deathYear();
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
