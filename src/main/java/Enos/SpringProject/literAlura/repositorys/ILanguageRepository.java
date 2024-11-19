package Enos.SpringProject.literAlura.repositorys;

import Enos.SpringProject.literAlura.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ILanguageRepository extends JpaRepository<Language,Long> {

    @Query("SELECT DISTINCT l.language FROM Language l")
    List<String> findDistinctLanguages();
}
