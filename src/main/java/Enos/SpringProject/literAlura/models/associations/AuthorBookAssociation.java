package Enos.SpringProject.literAlura.models.associations;

import Enos.SpringProject.literAlura.models.Author;
import Enos.SpringProject.literAlura.models.Book;
import jakarta.persistence.*;

@Entity
@Table(name = "author_book")
public class AuthorBookAssociation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Author author;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Book book;

    public AuthorBookAssociation(){}

    public AuthorBookAssociation(Author author,Book book){
        this.author = author;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public Book getBook() {
        return book;
    }
}
