package Enos.SpringProject.literAlura.models;

import Enos.SpringProject.literAlura.exceptions.NullObjectException;
import Enos.SpringProject.literAlura.models.associations.TranslatorBookAssociation;
import Enos.SpringProject.literAlura.models.gutendex.PersonGutendex;

import java.util.List;

public class Translator extends Person{

    private List<TranslatorBookAssociation> books;

    public Translator(){super();}

    public Translator(PersonGutendex personGutendex){
        super(personGutendex);
    }

    public List<TranslatorBookAssociation> getBooks() {
        return books;
    }

    public void addBook(TranslatorBookAssociation book){
        if(book == null){
            throw new NullObjectException("cant add translators book, because is null");
        } else {
            books.add(book);
        }
    }
}
