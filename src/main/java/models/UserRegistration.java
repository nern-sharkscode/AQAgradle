package models;
import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
public class UserRegistration {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
