package ru.itgirlschool.web1.dto.mapper;

import org.mapstruct.Mapper;
import ru.itgirlschool.web1.dto.*;

@Mapper(componentModel = "spring")
public interface Web1CustomUserMapper {

    Web1CustomUserResponseDto mapFromCustomUserResponseDto(CustomUserResponseDto customUserResponseDto);

    CustomUserCreateDto mapFromWeb1CustomUserCreateDto(Web1CustomUserCreateDto web1CustomUserCreateDto);

    CustomUserUpdateDto mapFromWeb1CustomUserUpdateDto(Web1CustomUserUpdateDto web1CustomUserUpdateDto);
}