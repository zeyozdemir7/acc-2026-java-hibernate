package bootcamp.hibernate_practical.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@AllArgsConstructor
@Getter
public class BookResponse {

    private Long id;
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private boolean available;
}
