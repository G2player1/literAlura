package Enos.SpringProject.literAlura.services;

import Enos.SpringProject.literAlura.models.Author;
import Enos.SpringProject.literAlura.models.Book;
import Enos.SpringProject.literAlura.models.Format;
import Enos.SpringProject.literAlura.models.Translator;
import Enos.SpringProject.literAlura.models.associations.AuthorBookAssociation;
import Enos.SpringProject.literAlura.models.associations.TranslatorBookAssociation;

public class BookService {

    public void setBookFormats(Book book,Format format){
        book.setFormat(format);
    }

    public void setAuthorBookAssociation(Book book, Author author){
        AuthorBookAssociation authorBookAssociation = new AuthorBookAssociation(author,book);
        author.addBook(authorBookAssociation);
        book.addAuthor(authorBookAssociation);
    }

    public void setTranslatorBookAssociation(Book book, Translator translator){
        TranslatorBookAssociation translatorBookAssociation = new TranslatorBookAssociation(translator,book);
        translator.addBook(translatorBookAssociation);
        book.addTranslator(translatorBookAssociation);
    }
}