package Enos.SpringProject.literAlura.models;

import Enos.SpringProject.literAlura.exceptions.NullObjectException;
import Enos.SpringProject.literAlura.models.associations.AuthorBookAssociation;
import Enos.SpringProject.literAlura.models.gutendex.PersonGutendex;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<AuthorBookAssociation> books;

    public Author(){super();}

    public Author(PersonGutendex personGutendex){
        super(personGutendex);
        books = new ArrayList<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Integer getBirthYear(){
        return this.birthYear;
    }

    @Override
    public Integer getDeathYear(){
        return this.deathYear;
    }

    public List<AuthorBookAssociation> getBooks() {
        return books;
    }

    public void addBook(AuthorBookAssociation book){
        if(book == null){
            throw new NullObjectException("cant add authors book, because is null");
        } else {
            books.add(book);
        }
    }



    @Override
    public String toString() {
        return "-----------Autor-----------" + '\n' +
                "Nome: " + name + '\n' +
                "Ano de Nascimento: " + birthYear + '\n' +
                "Ano da Morte: " + deathYear + '\n' +
                "--------------------------" + '\n';
    }
}
