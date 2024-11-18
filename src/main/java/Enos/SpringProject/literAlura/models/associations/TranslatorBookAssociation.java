package Enos.SpringProject.literAlura.models.associations;

import Enos.SpringProject.literAlura.models.Book;
import Enos.SpringProject.literAlura.models.Translator;

public class TranslatorBookAssociation {

    private Translator translator;
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
