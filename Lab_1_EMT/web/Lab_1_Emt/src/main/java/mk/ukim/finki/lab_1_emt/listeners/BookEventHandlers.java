package mk.ukim.finki.lab_1_emt.listeners;

import mk.ukim.finki.lab_1_emt.model.events.BookCreatedEvent;
import mk.ukim.finki.lab_1_emt.service.BookService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookEventHandlers {

    private final BookService bookService;

    public BookEventHandlers(BookService bookService) {
        this.bookService = bookService;
    }

    @EventListener
    public void onBookCreated(BookCreatedEvent event) {
        this.bookService.refreshMaterializedView();
    }
}

