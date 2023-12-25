package ru.itgirlschool.web1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomUserResponseDto {
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private int age;
    private String email;
    private String phone;
    private String login;
}


