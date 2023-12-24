package ru.itgirlschool.core.service;

import ru.itgirlschool.core.dto.CustomUserCreateDto;
import ru.itgirlschool.core.dto.CustomUserResponseDto;
import ru.itgirlschool.core.dto.CustomUserUpdateDto;

import java.util.List;

public interface CustomUserService {

    List<CustomUserResponseDto> getAllUsers();

    CustomUserResponseDto getCustomUserById(Long id);

    List<CustomUserResponseDto> getCustomUsers();

    CustomUserResponseDto createCustomUser(CustomUserCreateDto customUserCreateDto);

    CustomUserResponseDto updateCustomUser(Long id, CustomUserUpdateDto customUserUpdateDto);

    void deleteCustomUser(Long id);

    void deleteCustomUsers(List<Long> ids);
}