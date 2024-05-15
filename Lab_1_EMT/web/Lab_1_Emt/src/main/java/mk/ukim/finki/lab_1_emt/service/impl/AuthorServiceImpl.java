package mk.ukim.finki.lab_1_emt.service.impl;
import mk.ukim.finki.lab_1_emt.model.Author;
import mk.ukim.finki.lab_1_emt.model.Country;
import mk.ukim.finki.lab_1_emt.model.dto.Authordto;
import mk.ukim.finki.lab_1_emt.model.exceptions.InvalidAuthorIdException;
import mk.ukim.finki.lab_1_emt.model.exceptions.InvalidCountryIdException;
import mk.ukim.finki.lab_1_emt.repository.AuthorRepository;
import mk.ukim.finki.lab_1_emt.repository.CountryRepository;
import mk.ukim.finki.lab_1_emt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(InvalidAuthorIdException::new);
    }

    @Override
    public List<Author> listAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author create(Authordto authordto) {
        Country country = countryRepository.findById(authordto.getCountry()).orElseThrow(InvalidCountryIdException::new);
        Author author = new Author(authordto.getName(), authordto.getSurname(), country);
        authorRepository.save(author);
        return author;
    }

}
