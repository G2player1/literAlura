package Enos.SpringProject.literAlura.models.associations;

import Enos.SpringProject.literAlura.models.Book;
import Enos.SpringProject.literAlura.models.Translator;
import jakarta.persistence.*;

@Entity
@Table(name = "translator_book")
public class TranslatorBookAssociation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Translator translator;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Book book;

    public TranslatorBookAssociation(){}

    public TranslatorBookAssociation(Translator translator,Book book){
        this.translator = translator;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Translator getTranslator() {
        return translator;
    }
}
