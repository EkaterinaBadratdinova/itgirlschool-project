package ru.itgirlschool.web1.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Role {
    private Long id;
   private RoleType role;
}
