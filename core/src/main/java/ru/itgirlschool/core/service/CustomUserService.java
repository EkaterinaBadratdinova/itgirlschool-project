package ru.itgirlschool.core.service;

import ru.itgirlschool.core.dto.CustomUserCreateDto;
import ru.itgirlschool.core.dto.CustomUserResponseDto;
import ru.itgirlschool.core.dto.CustomUserUpdateDto;

import java.util.List;

public interface CustomUserService {

    CustomUserResponseDto getCustomUserById(Long id);

    List<CustomUserResponseDto> getCustomUsers();

    CustomUserResponseDto createCustomUser(CustomUserCreateDto customUserCreateDto) throws Exception;

    CustomUserResponseDto updateCustomUser(Long id, CustomUserUpdateDto customUserUpdateDto) throws Exception;

    void deleteCustomUser(Long id);

    void deleteCustomUsers(List<Long> ids);
}