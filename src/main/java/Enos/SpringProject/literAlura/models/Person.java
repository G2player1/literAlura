package Enos.SpringProject.literAlura.models;

import Enos.SpringProject.literAlura.models.gutendex.PersonGutendex;

public abstract class Person {

    private Long id;
    protected String name;
    protected Integer birthYear;
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
