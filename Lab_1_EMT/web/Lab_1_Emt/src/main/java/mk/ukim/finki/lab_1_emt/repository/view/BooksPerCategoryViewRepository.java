package mk.ukim.finki.lab_1_emt.repository.view;

import jakarta.transaction.Transactional;
import mk.ukim.finki.lab_1_emt.model.view.BooksPerCategoryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksPerCategoryViewRepository extends JpaRepository<BooksPerCategoryView,Long> {
    @Transactional
    @Modifying
    @Query(value = "REFRESH MATERIALIZED VIEW public.books_per_type", nativeQuery = true)
    void refreshMaterializedView();
}
