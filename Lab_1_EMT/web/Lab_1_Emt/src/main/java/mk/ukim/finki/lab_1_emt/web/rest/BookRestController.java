package mk.ukim.finki.lab_1_emt.web.rest;

import mk.ukim.finki.lab_1_emt.model.Book;
import mk.ukim.finki.lab_1_emt.model.BookType;
import mk.ukim.finki.lab_1_emt.model.dto.Bookdto;
import mk.ukim.finki.lab_1_emt.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;


    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Book> listBooks() {
        return this.bookService.listAll();
    }

    @GetMapping
    public List<Book> listBooksPaginated(Pageable pageable) {
        return this.bookService.listBooksPaginated(pageable).getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(book);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Bookdto book) {
        Book newBook = bookService.create(book);

        if (newBook == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(newBook);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody Bookdto book) {
        Book newBook = bookService.update(id, book);

        if (newBook == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(newBook);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Book book = bookService.findById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            bookService.delete(id);
            return ResponseEntity.ok(book);
        }
    }

    @PutMapping("/take/{id}")
    public ResponseEntity<Book> markBookAsTaken(@PathVariable Long id) {
        Book book = bookService.findById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            bookService.take(id);
            return ResponseEntity.ok(book);
        }
    }

}