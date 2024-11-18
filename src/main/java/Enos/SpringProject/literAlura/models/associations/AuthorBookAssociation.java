package Enos.SpringProject.literAlura.models.associations;

import Enos.SpringProject.literAlura.models.Author;
import Enos.SpringProject.literAlura.models.Book;

public class AuthorBookAssociation {

    private Author author;
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
