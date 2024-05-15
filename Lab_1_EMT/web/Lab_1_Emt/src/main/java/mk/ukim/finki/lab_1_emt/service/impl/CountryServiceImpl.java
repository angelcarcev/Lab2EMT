package mk.ukim.finki.lab_1_emt.service.impl;

import mk.ukim.finki.lab_1_emt.model.Country;
import mk.ukim.finki.lab_1_emt.model.dto.Countrydto;
import mk.ukim.finki.lab_1_emt.model.exceptions.InvalidCountryIdException;
import mk.ukim.finki.lab_1_emt.repository.CountryRepository;
import mk.ukim.finki.lab_1_emt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(InvalidCountryIdException::new);
    }

    @Override
    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country create(Countrydto country) {
        Country newCountry = new Country();

        newCountry.setName(country.getName());

        return countryRepository.save(newCountry);
    }


    @Override
    public Country editCountry(Long id, Countrydto country) {
        Country newCountry = countryRepository.findById(id).orElseThrow(InvalidCountryIdException::new);

        if (newCountry == null) {
            return null;
        }

        newCountry.setName(country.getName());

        return countryRepository.save(newCountry);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }

}
