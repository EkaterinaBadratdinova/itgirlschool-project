package ru.itgirlschool.web1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itgirlschool.web1.entity.Role;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private int age;
    private String email;
    private String phone;
    private String login;
    private String password;
    private Set<Role> roles;
}
