package mk.ukim.finki.lab_1_emt.service;

import mk.ukim.finki.lab_1_emt.model.Book;
import mk.ukim.finki.lab_1_emt.model.BookType;
import mk.ukim.finki.lab_1_emt.model.dto.Bookdto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<Book> listAll();
    Page<Book> listBooksPaginated(Pageable pageable);
    Book findById(Long id);
    Book create (Bookdto bookdto);

    Book update (Long id, Bookdto bookdto);

    Book delete (Long id);
    Book take(Long id);
    void refreshMaterializedView();

}
