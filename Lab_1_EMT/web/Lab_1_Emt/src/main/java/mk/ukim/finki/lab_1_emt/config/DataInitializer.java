package mk.ukim.finki.lab_1_emt.config;

import lombok.Getter;
import mk.ukim.finki.lab_1_emt.model.Author;
import mk.ukim.finki.lab_1_emt.model.Book;
import mk.ukim.finki.lab_1_emt.model.BookType;
import mk.ukim.finki.lab_1_emt.model.Country;
import mk.ukim.finki.lab_1_emt.repository.AuthorRepository;
import mk.ukim.finki.lab_1_emt.repository.BookRepository;
import mk.ukim.finki.lab_1_emt.repository.CountryRepository;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataInitializer {
    public List<Book> books = new ArrayList<>();
    public List<Author> authors = new ArrayList<>();
    public List<Country> countries = new ArrayList<>();
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init() {

        //Countries init
        countries.add(new Country("Belgium", "Europe"));
        countries.add(new Country("Germany", "Europe"));
        countries.add(new Country("USA", "North America"));
        countries.add(new Country("Chile", "South America"));
        countries.add(new Country("Japan", "Asia"));
        countries.add(new Country("Russia", "Europe"));


        this.countryRepository.saveAll(countries);

        //Authors init
        Author author1 = new Author("Miguel", "de Cervantes", countries.get((int) (Math.random() * countries.size())));
        Author author2 = new Author("Charles", "Dickens", countries.get((int) (Math.random() * countries.size())));
        Author author3 = new Author("William", "Shakespeare", countries.get((int) (Math.random() * countries.size())));
        Author author4 = new Author("J. R. R.", "Tolkien", countries.get((int) (Math.random() * countries.size())));
        Author author5 = new Author("Fyodor", "Dostoevsky", countries.get((int) (Math.random() * countries.size())));

        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
        authors.add(author4);
        authors.add(author5);

        this.authorRepository.saveAll(authors);

        // BooksInit
        books.add(new Book("Don Quixote", BookType.CLASSICS, author1, 50));
        books.add(new Book("A Tale of Two Cities", BookType.HISTORY, author2, 50));
        books.add(new Book("The Lord of the Rings", BookType.FANTASY, author4, 50));
        books.add(new Book("The walking dead", BookType.THRILLER, author3, 50));
        books.add(new Book("New world", BookType.DRAMA, author5, 50));
        books.add(new Book("Here we go!", BookType.NOVEL, author1, 50));

        this.bookRepository.saveAll(books);
    }
}