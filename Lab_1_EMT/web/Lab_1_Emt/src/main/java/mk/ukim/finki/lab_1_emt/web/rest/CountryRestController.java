package mk.ukim.finki.lab_1_emt.web.rest;

import mk.ukim.finki.lab_1_emt.model.Country;
import mk.ukim.finki.lab_1_emt.model.dto.Countrydto;
import mk.ukim.finki.lab_1_emt.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/countries")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/list")
    public List<Country> getAllCountries() {
        return countryService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        Country country = countryService.findById(id);

        if (country == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(country);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Country> create(@RequestBody Countrydto country) {
        Country newCountry = countryService.create(country);

        if (newCountry == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(newCountry);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> editCountry(@PathVariable Long id,
                                               @RequestBody Countrydto country) {
        Country newCountry = countryService.editCountry(id, country);

        if (newCountry == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(newCountry);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable Long id) {
        Country country = countryService.findById(id);

        if (country == null) {
            return ResponseEntity.notFound().build();
        } else {
            countryService.deleteCountry(id);
            return ResponseEntity.ok().build();
        }
    }
}

