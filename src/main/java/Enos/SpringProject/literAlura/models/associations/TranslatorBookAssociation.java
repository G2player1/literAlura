package Enos.SpringProject.literAlura.models.associations;

import Enos.SpringProject.literAlura.models.Book;
import Enos.SpringProject.literAlura.models.Translator;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "translator_book")
public class TranslatorBookAssociation {

    @ManyToOne
    private Translator translator;
    @ManyToOne
    private Book book;

    public TranslatorBookAssociation(){}

    public TranslatorBookAssociation(Translator translator,Book book){
        this.translator = translator;
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public Translator getTranslator() {
        return translator;
    }
}
