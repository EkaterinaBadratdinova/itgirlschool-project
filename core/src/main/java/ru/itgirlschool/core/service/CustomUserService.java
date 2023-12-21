package ru.itgirlschool.core.service;

import ru.itgirlschool.core.dto.CustomUserCreateDto;
import ru.itgirlschool.core.dto.CustomUserRequestDto;
import ru.itgirlschool.core.dto.CustomUserResponseDto;
import ru.itgirlschool.core.dto.CustomUserUpdateDto;

import java.util.List;

public interface CustomUserService {

    CustomUserResponseDto getUserById(Long id);

    List<CustomUserResponseDto> getAllUsers();

    CustomUserResponseDto createUser(CustomUserRequestDto customUserDto);

    CustomUserResponseDto updateUser(Long id, CustomUserRequestDto customUserDto);

    void deleteUser(Long id);

    void deleteUsers(List<Long> ids);

    CustomUserResponseDto getCustomUserById(Long id);

    List<CustomUserResponseDto> getCustomUsers();

    CustomUserResponseDto createCustomUser(CustomUserRequestDto customUserDto);

    CustomUserResponseDto updateCustomUser(Long id, CustomUserRequestDto customUserDto);

    CustomUserResponseDto createCustomUser(CustomUserCreateDto customUserCreateDto);

    CustomUserResponseDto updateCustomUser(Long id, CustomUserUpdateDto customUserUpdateDto);

    void deleteCustomUser(Long id);

    void deleteCustomUsers(List<Long> ids);
}