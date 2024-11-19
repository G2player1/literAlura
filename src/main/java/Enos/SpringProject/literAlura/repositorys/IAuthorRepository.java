package Enos.SpringProject.literAlura.repositorys;

import Enos.SpringProject.literAlura.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author,Long> {
}
