package Enos.SpringProject.literAlura.models;

import Enos.SpringProject.literAlura.exceptions.NullObjectException;
import Enos.SpringProject.literAlura.models.associations.TranslatorBookAssociation;
import Enos.SpringProject.literAlura.models.gutendex.PersonGutendex;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "translators")
public class Translator extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "translator",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
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
