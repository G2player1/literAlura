package Enos.SpringProject.literAlura.models;

import Enos.SpringProject.literAlura.models.gutendex.FormatGuntedex;

public class Format {

    private Long id;
    private String text_html;
    private String text_html_ascii;
    private String application_epub_zip;
    private String application_xmobipocket_ebook;
    private String application_rdf_xml;
    private String image_jpeg;
    private String text_plain_us_ascii;
    private String text_plain_utf8;
    private String application_octet_stream;
    private Book book;

    public Format(){}

    public Format(FormatGuntedex formatGuntedex,Book book){
        this.text_html = formatGuntedex.text_html();
        this.text_html_ascii = formatGuntedex.text_html_ascii();
        this.application_epub_zip = formatGuntedex.application_epub_zip();
        this.application_xmobipocket_ebook = formatGuntedex.application_xmobipocket_ebook();
        this.application_rdf_xml = formatGuntedex.application_rdf_xml();
        this.image_jpeg = formatGuntedex.image_jpeg();
        this.text_plain_us_ascii = formatGuntedex.text_plain_us_ascii();
        this.text_plain_utf8 = formatGuntedex.text_plain_utf8();
        this.application_octet_stream = formatGuntedex.application_octet_stream();
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public String getImage_jpeg() {
        return image_jpeg;
    }

    public String getText_html() {
        return text_html;
    }

    public String getText_html_ascii() {
        return text_html_ascii;
    }

    public String getText_plain_us_ascii() {
        return text_plain_us_ascii;
    }

    public String getText_plain_utf8() {
        return text_plain_utf8;
    }

    public String getApplication_epub_zip() {
        return application_epub_zip;
    }

    public String getApplication_octet_stream() {
        return application_octet_stream;
    }

    public String getApplication_rdf_xml() {
        return application_rdf_xml;
    }

    public String getApplication_xmobipocket_ebook() {
        return application_xmobipocket_ebook;
    }

    public Book getBook() {
        return book;
    }
}
