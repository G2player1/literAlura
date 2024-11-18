package Enos.SpringProject.literAlura.models;

import Enos.SpringProject.literAlura.exceptions.NullObjectException;
import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "subject")
    private String subject;
    @ManyToOne
    private Book book;

    public Subject(){}

    public Subject(String subject){
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
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
