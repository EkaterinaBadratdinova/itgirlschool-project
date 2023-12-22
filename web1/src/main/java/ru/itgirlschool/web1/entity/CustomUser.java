package ru.itgirlschool.web1.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Set;

@Data
@EqualsAndHashCode
public class CustomUser {
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
