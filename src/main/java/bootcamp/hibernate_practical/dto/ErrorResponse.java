package bootcamp.hibernate_practical.dto;
import lombok.Getter;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Getter

public class ErrorResponse {
    private int status;
    private String message;
}
