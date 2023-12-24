package ru.itgirlschool.web1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Web1CustomUserResponseDto {
    private String firstName;
    private String lastName;
    private Integer age;
}
