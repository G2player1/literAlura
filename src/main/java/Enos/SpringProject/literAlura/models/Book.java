package Enos.SpringProject.literAlura.models;

import Enos.SpringProject.literAlura.exceptions.NullObjectException;
import Enos.SpringProject.literAlura.models.associations.AuthorBookAssociation;
import Enos.SpringProject.literAlura.models.associations.TranslatorBookAssociation;
import Enos.SpringProject.literAlura.models.gutendex.BookGutendex;

import java.util.List;

public class Book {

    private Long id;
    private String title;
    private List<String> subjects;
    private List<String> bookshelves;
    private List<String> languages;
    private Boolean copyright;
    private String mediaType;
    private Integer downloads;
    private List<TranslatorBookAssociation> translators;
    private List<AuthorBookAssociation> authors;
    private Format format;

    public Book(){}

    public Book(BookGutendex bookGutendex){
        this.id = bookGutendex.id();
        this.title = bookGutendex.title();
        this.subjects = bookGutendex.subjects();
        this.bookshelves = bookGutendex.bookshelves();
        this.languages = bookGutendex.languages();
        this.copyright = bookGutendex.copyright();
        this.mediaType = bookGutendex.mediaType();
        this.downloads = bookGutendex.downloads();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<TranslatorBookAssociation> getTranslators() {
        return translators;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public String getMediaType() {
        return mediaType;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public Format getFormat() {
        return format;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public Boolean getCopyright() {
        return copyright;
    }

    public List<String> getBookshelves() {
        return bookshelves;
    }

    public List<AuthorBookAssociation> getAuthors() {
        return authors;
    }

    public void setFormat(Format format){
        if(format == null){
            throw new NullObjectException("Cant set formats, because format is null");
        } else {
            this.format = format;
        }
    }

    public void addAuthor(AuthorBookAssociation author){
        if(author == null){
            throw new NullObjectException("cant add book's author, because author is null");
        } else {
            this.authors.add(author);
        }
    }

    public void addTranslator(TranslatorBookAssociation translator){
        if(translator == null){
            throw new NullObjectException("cant add book's translator, because translator is null");
        } else {
            this.translators.add(translator);
        }
    }
}
