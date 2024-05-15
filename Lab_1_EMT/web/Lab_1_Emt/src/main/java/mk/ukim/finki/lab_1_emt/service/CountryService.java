package mk.ukim.finki.lab_1_emt.service;

import mk.ukim.finki.lab_1_emt.model.Country;
import mk.ukim.finki.lab_1_emt.model.dto.Countrydto;

import java.util.List;

public interface CountryService {
    Country findById(Long id);
    List<Country> listAll();
    Country create (Countrydto country);

    Country editCountry(Long id, Countrydto country);

    void deleteCountry(Long id);
}
