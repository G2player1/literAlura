package Enos.SpringProject.literAlura.repositorys;

import Enos.SpringProject.literAlura.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {

    Book findBookById(Long id);

    List<Book> findByLanguages_Language(String language);
}
