package Enos.SpringProject.literAlura.models;

import java.util.List;

public abstract class Person {

    private Long id;
    protected String name;
    protected Integer birthYear;
    protected Integer deathYear;
    protected List<Book> books;


}
