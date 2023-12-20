package ru.itgirlschool.core.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itgirlschool.core.dto.CustomUserUpdateDto;
import ru.itgirlschool.core.entity.CustomUser;
import ru.itgirlschool.core.dto.CustomUserCreateDto;

@Mapper(componentModel = "spring")
public interface CustomUserMapper {
    @Mapping(target = "userRoles", ignore = true)
    CustomUser mapFromDto (CustomUserCreateDto customUserCreateDto);

    @Mapping(target = "userRoles", ignore = true)
    CustomUser mapFromDto(CustomUserUpdateDto customUserUpdateDto);

    @Mapping(target = "userRoles", ignore = true)
    CustomUserCreateDto createUserDto (CustomUser customUser);

    @Mapping(target = "userRoles", ignore = true)
    CustomUserUpdateDto updateUserDto (CustomUser customUser);
}
