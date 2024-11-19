package Enos.SpringProject.literAlura.repositorys;

import Enos.SpringProject.literAlura.models.Translator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITranslatorRepository extends JpaRepository<Translator,Long> {
}
