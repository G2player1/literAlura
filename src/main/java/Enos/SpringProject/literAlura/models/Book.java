package Enos.SpringProject.literAlura.models;

import Enos.SpringProject.literAlura.exceptions.NullObjectException;
import Enos.SpringProject.literAlura.models.associations.AuthorBookAssociation;
import Enos.SpringProject.literAlura.models.associations.TranslatorBookAssociation;
import Enos.SpringProject.literAlura.models.gutendex.BookGutendex;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    private Long id;
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Subject> subjects;
    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Bookshelve> bookshelves;
    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Language> languages;
    @Column(name = "copyright")
    private Boolean copyright;
    @Column(name = "media_type")
    private String mediaType;
    @Column(name = "downloads")
    private Integer downloads;
    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<TranslatorBookAssociation> translators;
    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<AuthorBookAssociation> authors;
    @OneToOne(mappedBy = "book",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Format format;

    public Book(){}

    public Book(BookGutendex bookGutendex){
        subjects = new ArrayList<>();
        bookshelves = new ArrayList<>();
        languages = new ArrayList<>();
        translators = new ArrayList<>();
        authors = new ArrayList<>();
        this.id = bookGutendex.id();
        if(bookGutendex.title().length() > 255){
            this.title = bookGutendex.title().substring(0,255);
        } else {
            this.title = bookGutendex.title();
        }
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

    public List<Subject> getSubjects() {
        return subjects;
    }

    public String getMediaType() {
        return mediaType;
    }

    public List<Language> getLanguages() {
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

    public List<Bookshelve> getBookshelves() {
        return bookshelves;
    }

    public List<AuthorBookAssociation> getAuthors() {
        return authors;
    }

    public void addLanguage(Language language){
        if(language == null){
            throw new NullObjectException("Cant add subject, because subject is null");
        } else {
            this.languages.add(language);
        }
    }

    public void addBookshelve(Bookshelve bookshelve){
        if(bookshelve == null){
            throw new NullObjectException("Cant add subject, because subject is null");
        } else {
            this.bookshelves.add(bookshelve);
        }
    }

    public void addSubject(Subject subject){
        if(subject == null){
            throw new NullObjectException("Cant add subject, because subject is null");
        } else {
            this.subjects.add(subject);
        }
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

    public String authorsToString(){
        StringBuilder msg = new StringBuilder();
        for (AuthorBookAssociation authorBook : authors){
            Author author = authorBook.getAuthor();
            msg.append(author.getName()).append("(").append(author.getBirthYear()).append("/").append(author.getDeathYear()).append(")").append("\n");
        }
        return msg.toString();
    }

    public String languagesToString(){
        StringBuilder msg = new StringBuilder();
        for (Language language : languages){
            msg.append(language.getLanguage()).append("; ");
        }
        return msg.toString();
    }

    @Override
    public String toString() {
        return "----------------Livro----------------" + "\n" +
                "Id: " + this.id + "\n" +
                "Título: " + this.title + "\n" +
                "Autor(es): " + this.authorsToString() + "\n" +
                "Idioma(s): " + this.languagesToString() + "\n" +
                "Número de downloads: " + this.downloads + "\n" +
                "------------------------------------" + "\n";
    }
}
