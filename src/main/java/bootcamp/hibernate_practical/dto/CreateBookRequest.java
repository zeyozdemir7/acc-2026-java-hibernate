package bootcamp.hibernate_practical.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;


import lombok.Getter;

@Getter
public class CreateBookRequest {

    @NotBlank(message = "Book title is required")
    private String title;

    @NotBlank(message = "Author name is required")
    private String author;

    @NotBlank(message = "Book genre is required")
    private String genre;

    @Min(value = 1000, message = "Publication year must be valid.")
    @Max(value = 2050, message = "Publication year must be valid.")
    private int publicationYear;
}
