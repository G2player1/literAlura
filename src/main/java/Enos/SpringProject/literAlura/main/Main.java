package Enos.SpringProject.literAlura.main;

import Enos.SpringProject.literAlura.controllers.LiterAluraController;
import Enos.SpringProject.literAlura.exceptions.CantGetWebDataException;
import Enos.SpringProject.literAlura.models.Author;
import Enos.SpringProject.literAlura.models.Book;
import Enos.SpringProject.literAlura.models.Language;
import Enos.SpringProject.literAlura.models.gutendex.BookGutendex;
import Enos.SpringProject.literAlura.models.gutendex.ResultGutendex;
import Enos.SpringProject.literAlura.repositorys.IAuthorRepository;
import Enos.SpringProject.literAlura.repositorys.IBookRepository;
import Enos.SpringProject.literAlura.repositorys.ILanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

public class Main {

    private IBookRepository bookRepository;
    private IAuthorRepository authorRepository;
    private ILanguageRepository languageRepository;
    private final LiterAluraController controller = new LiterAluraController();

    public Main(){}

    @Autowired
    public Main(IBookRepository bookRepository,
                IAuthorRepository authorRepository,
                ILanguageRepository languageRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.languageRepository = languageRepository;
    }

    public void start(){
        System.out.println("Hello World");
        Scanner sc = new Scanner(System.in);
        int op = -1;
        do {
            String msg = """
                    1 - Buscar livro pelo titulo
                    2 - listar livros registrados
                    3 - listar autores registrados
                    4 - listar autores vivos em um determinado periodo
                    5 - Buscar livros por idioma
                    
                    0 - sair
                    """;
            System.out.println(msg);
            op = sc.nextInt();
            sc.nextLine();
            switch (op){
                case 1:
                    this.searchBook(sc);
                    break;
                case 2:
                    this.showBooksInDB();
                    break;
                case 3:
                    this.showAuthorsInDB();
                    break;
                case 4:
                    this.showAuthorsInDbByYear(sc);
                    break;
                case 5:
                    this.showBooksInDbByLanguage(sc);
                    break;
                case 0:
                    System.out.println("Até a próxima");
                    break;
                default:
                    System.out.println("opção invalida");
                    break;
            }
        }while(op != 0);
    }

    public void searchBook(Scanner sc){
        System.out.println("Insira o nome do livro: ");
        String search = sc.nextLine();
        String address = getAddressByTitle(search);
        ResultGutendex results = null;
        try {
             results = controller.getWebData(address, ResultGutendex.class);
        } catch (CantGetWebDataException e) {
            System.out.println(e.getMessage());
            return;
        }
        for(BookGutendex bookGutendex : results.results()){
            Book book = instanceBook(bookGutendex);
            System.out.println(book);
        }
    }

    public void showAuthorsInDB(){
        this.getAuthorsInDB().forEach(System.out::println);
    }

    public void showAuthorsInDbByYear(Scanner sc){
        System.out.println("Determine um periodo");
        System.out.println("informe o ano de inicio: ");
        int startYear = sc.nextInt();
        sc.nextLine();
        System.out.println("informe o ano de termino: ");
        int endYear = sc.nextInt();
        sc.nextLine();
        if(startYear > endYear){
            System.out.println("não consigo determinar o periodo");
            return;
        }
        this.getAuthorsInDB()
                .stream()
                .filter(author -> author.getBirthYear() != null && author.getDeathYear() != null)
                .filter(author -> author.getBirthYear() >= startYear && author.getDeathYear() <= endYear)
                .forEach(System.out::println);
    }

    public void showBooksInDbByLanguage(Scanner sc){
        int i = 0;
        for (String language : getDistinctLanguages()){
            System.out.println((i + 1) + " - " + language);
            i++;
        }
        System.out.println("selecione uma linugagem");
        int op = sc.nextInt();
        sc.nextLine();
        if(op > getDistinctLanguages().size() || op <= 0){
            System.out.println("opção invalida");
            return;
        }
        String language = getDistinctLanguages().get(op - 1);
        getBooksInDBByLanguage(language).forEach(System.out::println);
    }

    public void showBooksInDB(){
        this.getBooksInDB().forEach(System.out::println);
    }

    public List<Book> getBooksInDBByLanguage(String language){
        return bookRepository.findByLanguages_Language(language);
    }

    public List<String> getDistinctLanguages(){
        return languageRepository.findDistinctLanguages();
    }

    public List<Book> getBooksInDB(){
        return bookRepository.findAll();
    }

    public List<Author> getAuthorsInDB(){
        return authorRepository.findAll();
    }

    public Book getDatabaseBookByID(Long id){
        return bookRepository.findBookById(id);
    }

    public Book instanceBook(BookGutendex bookGutendex){
        Book book = new Book(bookGutendex);
        controller.setBookAuthors(book,bookGutendex.authors());
        controller.setBookTranslators(book,bookGutendex.translators());
        controller.setBookFormats(book,bookGutendex.format());
        controller.setBookSubjects(book,bookGutendex.subjects());
        controller.setBookLanguages(book,bookGutendex.languages());
        controller.setBookBookshelves(book,bookGutendex.bookshelves());
        if(getDatabaseBookByID(book.getId()) != null){
            return book;
        }
        bookRepository.save(book);
        return book;
    }

    public String getAddressByTitle(String search){
        return "https://gutendex.com/books?search=" + search.replace(" ","+");
    }

}
