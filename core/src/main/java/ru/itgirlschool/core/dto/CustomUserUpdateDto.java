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
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private int age;
    private String email;
    private String phone;
    private String login;
    private String password;

    private Boolean isChangePassword;
}
