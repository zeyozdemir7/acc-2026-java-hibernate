package bootcamp.hibernate_practical.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import lombok.Getter;

@Getter
public class UpdateBookRequest {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    @NotBlank(message = "Genre is required")
    private String genre;

    @Min(value = 1000, message = "Publication year must be realistic")
    @Max(value = 2100, message = "Publication year must be realistic")
    private int publicationYear;

    public boolean available;
}
