package ru.itgirlschool.core.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itgirlschool.core.dto.CustomUserResponseDto;
import ru.itgirlschool.core.entity.CustomUser;
import ru.itgirlschool.core.dto.CustomUserCreateDto;

@Mapper(componentModel = "spring")
public interface CustomUserMapper {

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "userRoles", ignore = true)
    CustomUser mapFromUserCreateDto (CustomUserCreateDto customUserCreateDto);

    @Mapping(target = "", source = "id", ignore = true)
    @Mapping(target = "", source = "password", ignore = true)
    @Mapping(target = "", source = "roles", ignore = true)
    CustomUserResponseDto mapToResponseUserDto (CustomUser customUser);
}
