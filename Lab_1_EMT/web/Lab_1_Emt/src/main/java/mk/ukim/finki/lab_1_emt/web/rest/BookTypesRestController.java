package mk.ukim.finki.lab_1_emt.web.rest;

import mk.ukim.finki.lab_1_emt.model.BookType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class BookTypesRestController {
    @GetMapping
    public List<BookType> allCategories(){
        return Arrays.stream(BookType.values()).toList();
    }
}
