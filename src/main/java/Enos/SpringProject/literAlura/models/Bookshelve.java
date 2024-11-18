package Enos.SpringProject.literAlura.models;

import Enos.SpringProject.literAlura.exceptions.NullObjectException;
import jakarta.persistence.*;

@Entity
@Table(name = "bookshelves")
public class Bookshelve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "bookshelve")
    private String bookshelve;
    @ManyToOne
    private Book book;

    public Bookshelve(){}

    public Bookshelve(String bookshelve){
        this.bookshelve = bookshelve;
    }

    public Long getId() {
        return id;
    }

    public String getBookshelve() {
        return bookshelve;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book){
        if(book == null){
            throw new NullObjectException("Cant add book, because book is null");
        } else {
            this.book = book;
        }
    }
}
