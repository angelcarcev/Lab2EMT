package mk.ukim.finki.lab_1_emt.web.rest;

import mk.ukim.finki.lab_1_emt.model.Author;
import mk.ukim.finki.lab_1_emt.service.AuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorsRestController {

    private final AuthorService authorService;

    public AuthorsRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> allAuthors(){
        return authorService.listAll();
    }
}
