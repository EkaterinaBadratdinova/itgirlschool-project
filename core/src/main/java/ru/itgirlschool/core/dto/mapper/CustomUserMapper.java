package ru.itgirlschool.core.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itgirlschool.core.dto.CustomUserResponseDto;
import ru.itgirlschool.core.dto.CustomUserUpdateDto;
import ru.itgirlschool.core.entity.CustomUser;
import ru.itgirlschool.core.dto.CustomUserCreateDto;

@Mapper(componentModel = "spring")
public interface CustomUserMapper {
    @Mapping(target = "userRoles", ignore = true)
    CustomUser mapFromUserCreateDto (CustomUserCreateDto customUserCreateDto);

    @Mapping(target = "userRoles", ignore = true)
    CustomUser mapFromUserUpdateDto(CustomUserUpdateDto customUserUpdateDto);

    @Mapping(target = "userRoles", ignore = true)
    CustomUserCreateDto mapToCreateUserDto (CustomUser customUser);

    @Mapping(target = "userRoles", ignore = true)
    CustomUserUpdateDto mapToUpdateUserDto (CustomUser customUser);

    @Mapping(target = "", source = "roles", ignore = true)
    @Mapping(target = "", source = "id", ignore = true)
    @Mapping(target = "", source = "password", ignore = true)
    CustomUserResponseDto mapToResponseUserDto (CustomUser customUser);
}
