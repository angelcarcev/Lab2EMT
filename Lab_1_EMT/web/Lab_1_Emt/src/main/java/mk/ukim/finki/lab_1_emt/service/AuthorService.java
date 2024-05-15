package mk.ukim.finki.lab_1_emt.service;

import mk.ukim.finki.lab_1_emt.model.Author;
import mk.ukim.finki.lab_1_emt.model.dto.Authordto;
import mk.ukim.finki.lab_1_emt.model.dto.Bookdto;

import java.util.List;

public interface AuthorService {
    Author findById(Long id);
    List<Author> listAll();
    Author create (Authordto authordto);
}
