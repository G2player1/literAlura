package Enos.SpringProject.literAlura.models;

import com.sun.java.accessibility.util.Translator;

import java.text.Format;
import java.util.List;

public class Book {

    private Long id;
    private String title;
    private List<String> subjects;
    private List<Translator> translators;
    private List<Author> authors;
    private Format format;

}
