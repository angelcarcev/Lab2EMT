package mk.ukim.finki.lab_1_emt.model.dto;
import lombok.Data;
import mk.ukim.finki.lab_1_emt.model.BookType;

import java.util.List;

@Data
public class Bookdto {
    private String name;

    private BookType category;

    private Long author;

    private Integer availableCopies;
}
