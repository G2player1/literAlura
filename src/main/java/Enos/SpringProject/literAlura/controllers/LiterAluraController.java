package Enos.SpringProject.literAlura.controllers;

import Enos.SpringProject.literAlura.models.Book;
import Enos.SpringProject.literAlura.models.gutendex.FormatGuntedex;
import Enos.SpringProject.literAlura.models.gutendex.PersonGutendex;
import Enos.SpringProject.literAlura.repositorys.IBookRepository;
import Enos.SpringProject.literAlura.services.BookService;
import Enos.SpringProject.literAlura.services.ConsumeAPI;
import Enos.SpringProject.literAlura.services.ConvertData;

import java.util.List;

public class LiterAluraController {

    private final BookService bookService = new BookService();
    private final ConsumeAPI consumeAPI = new ConsumeAPI();
    private final ConvertData convertData = new ConvertData();

    public <T> T getWebData(String address,Class<T> tclass){
        String json = consumeAPI.getData(address);
        return convertData.getData(json,tclass);
    }

    public void setBookAuthors(Book book, List<PersonGutendex> authors){
        bookService.setBookAuthors(book,authors);
    }

    public void setBookTranslators(Book book, List<PersonGutendex> translators){
        bookService.setBookTranslators(book,translators);
    }

    public void setBookFormats(Book book, FormatGuntedex format){
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
