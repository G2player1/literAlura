package Enos.SpringProject.literAlura.models.gutendex;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookGutendex
        (
                @JsonAlias("id")
                Long id,
                @JsonAlias("title")
                String title,
                @JsonAlias("subjects")
                List<String> subjects,
                @JsonAlias("bookshelves")
                List<String> bookshelves,
                @JsonAlias("languages")
                List<String> languages,
                @JsonAlias("copyright")
                Boolean copyright,
                @JsonAlias("media_type")
                String mediaType,
                @JsonAlias("download_count")
                Integer downloads,
                @JsonAlias("translators")
                List<PersonGutendex> translators,
                @JsonAlias("authors")
                List<PersonGutendex> authors,
                @JsonAlias("formats")
                FormatGuntedex format
        ) {

}
