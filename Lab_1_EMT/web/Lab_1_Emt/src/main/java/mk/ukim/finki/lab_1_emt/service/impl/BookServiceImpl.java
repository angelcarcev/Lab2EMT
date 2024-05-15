package mk.ukim.finki.lab_1_emt.service.impl;

import mk.ukim.finki.lab_1_emt.model.Author;
import mk.ukim.finki.lab_1_emt.model.Book;
import mk.ukim.finki.lab_1_emt.model.BookType;
import mk.ukim.finki.lab_1_emt.model.dto.Bookdto;
import mk.ukim.finki.lab_1_emt.model.exceptions.InvalidAuthorIdException;
import mk.ukim.finki.lab_1_emt.model.exceptions.InvalidBookIdException;
import mk.ukim.finki.lab_1_emt.model.exceptions.NoAvailableCopiesLeftException;
import mk.ukim.finki.lab_1_emt.repository.AuthorRepository;
import mk.ukim.finki.lab_1_emt.repository.BookRepository;
import mk.ukim.finki.lab_1_emt.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> listBooksPaginated(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
    }

    @Override
    public Book create(Bookdto bookdto) {

        Author authors1 = authorRepository.findById(bookdto.getAuthor()).orElseThrow(InvalidAuthorIdException::new);
        Book book = new Book(bookdto.getName(), bookdto.getCategory(), authors1, bookdto.getAvailableCopies());
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book update(Long id, Bookdto bookdto) {
        Author authors1 = authorRepository.findById(id).orElseThrow(InvalidAuthorIdException::new);
        Book book = bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
        book.setId(id);
        book.setName(bookdto.getName());
        book.setCategory(bookdto.getCategory());
        book.setAuthor(authors1);
        book.setAvailableCopies(bookdto.getAvailableCopies());
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book delete(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
        bookRepository.deleteById(id);
        return book;
    }

    @Override
    public Book take(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
        if(book.getAvailableCopies()>0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
        } else{
            throw new NoAvailableCopiesLeftException();
        }
        bookRepository.save(book);
        return book;
    }

    @Override
    public void refreshMaterializedView() {

    }
}
