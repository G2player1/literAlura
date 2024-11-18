package Enos.SpringProject.literAlura.models.associations;

import Enos.SpringProject.literAlura.models.Author;
import Enos.SpringProject.literAlura.models.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "author_book")
public class AuthorBookAssociation {

    @ManyToOne
    private Author author;
    @ManyToOne
    private Book book;

    public AuthorBookAssociation(){}

    public AuthorBookAssociation(Author author,Book book){
        this.author = author;
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public Book getBook() {
        return book;
    }
}
