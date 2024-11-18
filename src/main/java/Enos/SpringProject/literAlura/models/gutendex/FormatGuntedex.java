package Enos.SpringProject.literAlura.models.gutendex;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FormatGuntedex
        (
                @JsonAlias("text/html")
                String text_html,
                @JsonAlias("text/plain; charset=us-ascii")
                String text_html_ascii,
                @JsonAlias("application/epub+zip")
                String application_epub_zip,
                @JsonAlias("application/x-mobipocket-ebook")
                String application_xmobipocket_ebook,
                @JsonAlias("application/rdf+xml")
                String application_rdf_xml,
                @JsonAlias("image/jpeg")
                String image_jpeg,
                @JsonAlias("text/plain; charset=us-ascii")
                String text_plain_us_ascii,
                @JsonAlias("text/plain; charset=utf-8")
                String text_plain_utf8,
                @JsonAlias("application/octet-stream")
                String application_octet_stream
        ) {

}
