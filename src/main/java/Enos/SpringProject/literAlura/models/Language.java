package Enos.SpringProject.literAlura.models;

import Enos.SpringProject.literAlura.exceptions.NullObjectException;
import jakarta.persistence.*;

@Entity
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "language")
    private String language;
    @ManyToOne
    private Book book;

    public Language(){}

    public Language(String language){
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        if(book == null){
            throw new NullObjectException("cant set book, because book is null");
        } else {
            this.book = book;
        }
    }
}
