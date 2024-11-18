package Enos.SpringProject.literAlura.models;

import Enos.SpringProject.literAlura.exceptions.NullObjectException;
import Enos.SpringProject.literAlura.models.associations.AuthorBookAssociation;
import Enos.SpringProject.literAlura.models.gutendex.PersonGutendex;

import java.util.List;

public class Author extends Person{

    private List<AuthorBookAssociation> books;

    public Author(){super();}

    public Author(PersonGutendex personGutendex){
        super(personGutendex);
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
}
