package Enos.SpringProject.literAlura.services;

import Enos.SpringProject.literAlura.models.*;
import Enos.SpringProject.literAlura.models.associations.AuthorBookAssociation;
import Enos.SpringProject.literAlura.models.associations.TranslatorBookAssociation;
import Enos.SpringProject.literAlura.models.gutendex.FormatGuntedex;
import Enos.SpringProject.literAlura.models.gutendex.PersonGutendex;

import java.util.List;

public class BookService {

    public void setBookFormats(Book book, FormatGuntedex formatGuntedex){
        Format format = new Format(formatGuntedex);
        format.setBook(book);
        book.setFormat(format);
    }

    public void setBookSubjects(Book book, List<String> subjectList){
        for (String string: subjectList){
            Subject subject = new Subject(string);
            subject.setBook(book);
            book.addSubject(subject);
        }
    }

    public void setBookBookshelves(Book book,List<String> bookshelveList){
        for (String string : bookshelveList){
            Bookshelve bookshelve = new Bookshelve(string);
            bookshelve.setBook(book);
            book.addBookshelve(bookshelve);
        }
    }

    public void setBookLanguages(Book book,List<String> languageList){
        for (String string : languageList){
            Language language = new Language(string);
            language.setBook(book);
            book.addLanguage(language);
        }
    }

    public void setBookAuthors(Book book, List<PersonGutendex> authors){
        for (PersonGutendex personGutendex : authors){
            Author author = new Author(personGutendex);
            setAuthorBookAssociation(book,author);
        }
    }

    public void setBookTranslators(Book book, List<PersonGutendex> translators){
        for (PersonGutendex personGutendex : translators){
            Translator translator = new Translator(personGutendex);
            setTranslatorBookAssociation(book,translator);
        }
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