package ru.itgirlschool.web1.service;

import java.util.List;

public interface Web1CustomUserService {

    public Web1CustomUserResponseDto getCustomUserById(Long id);

    public List<Web1CustomUserResponseDto> getCustomUsers();

    public Web1CustomUserResponseDto createCustomUser(Web1CustomUserCreateDto web1CustomUserCreateDto);

    public Web1CustomUserResponseDto updateCustomUser(Long id, Web1CustomUserUpdateDto web1CustomUserUpdateDto);

    public void deleteCustomUserById(Long id);

    public void deleteCustomUsers(List<Long> ids);
}
