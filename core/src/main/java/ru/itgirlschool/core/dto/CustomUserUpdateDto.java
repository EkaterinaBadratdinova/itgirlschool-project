package ru.itgirlschool.core.dto;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomUserUpdateDto {

    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]", message = "Name required")
    private String firstName;

    @Size(min = 2, max = 30)
    @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]", message = "Last name required")
    private String lastName;

    @Past
    @Pattern(regexp = "(0[1-9]|[12][0-9]|3[01])[.](0[1-9]|1[012])[.](19[20-99]|20)\\d\\d")
    private LocalDate birthday;

    @Pattern(regexp = "^(1[8-9]|[2-9][0-9]|[10-11][0-9]|[12][0-5])$")
    private int age;

    @Size(min = 6, max = 50)
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{6,}", message = "Invalid email address")
    private String email;

    @Size(min = 12, max = 20)
    @Pattern(regexp = "^((\\+7|7|8)+([0-9]){10})$", message = "Invalid phone number")
    private String phone;

    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9-_]{4,20}$")
    private String login;

    @Size(min = 8)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$")
    private String password;
}
