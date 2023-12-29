package ru.itgirlschool.web1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SignInCustomUserDto {
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9-_]{4,20}$", message = "Login length must be between 4 and 20 characters")
    private String login;

    @Size(min = 8, message = "Password length must contain at least 8 characters")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$")
    private String password;
}
