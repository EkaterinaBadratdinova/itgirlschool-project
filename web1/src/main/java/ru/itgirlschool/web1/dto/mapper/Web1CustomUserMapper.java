package ru.itgirlschool.web1.dto.mapper;

import org.mapstruct.Mapper;
import ru.itgirlschool.web1.dto.*;

@Mapper(componentModel = "spring")
public abstract class Web1CustomUserMapper {
    public abstract Web1CustomUserResponseDto mapFrom(CustomUserResponseDto customUserResponseDto);

    public abstract CustomUserCreateDto mapFrom(Web1CustomUserCreateDto web1CustomUserCreateDto);

    public abstract CustomUserUpdateDto mapFrom(Web1CustomUserUpdateDto web1CustomUserUpdateDto);

}
