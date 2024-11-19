package Enos.SpringProject.literAlura;

import Enos.SpringProject.literAlura.main.Main;
import Enos.SpringProject.literAlura.repositorys.IAuthorRepository;
import Enos.SpringProject.literAlura.repositorys.IBookRepository;
import Enos.SpringProject.literAlura.repositorys.ILanguageRepository;
import Enos.SpringProject.literAlura.repositorys.ITranslatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	@Autowired
	private IBookRepository bookRepository;
	@Autowired
	private IAuthorRepository authorRepository;
	@Autowired
	private ILanguageRepository languageRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(bookRepository,authorRepository,languageRepository);
		main.start();
	}
}
