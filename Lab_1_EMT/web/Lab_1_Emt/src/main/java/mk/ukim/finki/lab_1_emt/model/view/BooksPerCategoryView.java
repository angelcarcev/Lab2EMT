package mk.ukim.finki.lab_1_emt.model.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import mk.ukim.finki.lab_1_emt.model.BookType;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
@Entity
@Subselect("SELECT * FROM public.books_per_category")
@Immutable
public class BooksPerCategoryView {

    @Id
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "book_category")
    private BookType category;
}

