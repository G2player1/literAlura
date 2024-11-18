package Enos.SpringProject.literAlura.controllers;

import Enos.SpringProject.literAlura.models.*;
import Enos.SpringProject.literAlura.services.BookService;
import Enos.SpringProject.literAlura.services.ConsumeAPI;
import Enos.SpringProject.literAlura.services.ConvertData;

import java.util.List;

public class LiterAluraController {

    private final ConsumeAPI consumeAPI = new ConsumeAPI();
    private final ConvertData convertData = new ConvertData();
    private final BookService bookService = new BookService();

    public <T> T getWebData(String address,Class<T> tclass){
        String json = consumeAPI.getData(address);
        return convertData.getData(json,tclass);
    }

    public void setAuthorBookAssociation(Book book, Author author){
        bookService.setAuthorBookAssociation(book,author);
    }

    public void setTranslatorBookAssociation(Book book, Translator translator){
        bookService.setTranslatorBookAssociation(book,translator);
    }

    public void setBookFormats(Book book, Format format){
        bookService.setBookFormats(book,format);
    }

    public void setBookSubjects(Book book, List<String> subjects){
        bookService.setBookSubjects(book,subjects);
    }

    public void setBookBookshelves(Book book, List<String> bookshelves){
        bookService.setBookBookshelves(book,bookshelves);
    }

    public void setBookLanguages(Book book, List<String> languages){
        bookService.setBookLanguages(book,languages);
    }

}
