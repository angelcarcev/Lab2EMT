package mk.ukim.finki.lab_1_emt.repository;

import mk.ukim.finki.lab_1_emt.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
