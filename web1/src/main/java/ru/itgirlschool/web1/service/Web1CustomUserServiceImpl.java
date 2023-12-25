package ru.itgirlschool.web1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ru.itgirlschool.web1.dto.*;
import ru.itgirlschool.web1.dto.mapper.Web1CustomUserMapper;
import ru.itgirlschool.web1.feign.CustomUserCoreFeignClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Web1CustomUserServiceImpl implements Web1CustomUserService {

    private final CustomUserCoreFeignClient customUserCoreFeignClient;
    private final Web1CustomUserMapper web1CustomUserMapper;

    @Override
    public Web1CustomUserResponseDto getCustomUserById(Long id) {
        CustomUserResponseDto response = customUserCoreFeignClient.getCustomUserById(id);
        return web1CustomUserMapper.mapFromCustomUserResponseDto(response);
    }

    @Override
    public List<Web1CustomUserResponseDto> getCustomUsers() {
        List<CustomUserResponseDto> customUsers = customUserCoreFeignClient.getCustomUsers();
        return customUsers.stream()
                .map(customUser -> web1CustomUserMapper.mapFromCustomUserResponseDto(customUser))
                .collect(Collectors.toList());
    }

    @Override
    public Web1CustomUserResponseDto createCustomUser(Web1CustomUserCreateDto web1CustomUserCreateDto) {
        CustomUserCreateDto request = web1CustomUserMapper.mapFromWeb1CustomUserCreateDto(web1CustomUserCreateDto);
        CustomUserResponseDto response = customUserCoreFeignClient.createCustomUser(request);
        return web1CustomUserMapper.mapFromCustomUserResponseDto(response);
    }

    @Override
    public Web1CustomUserResponseDto updateCustomUser(Long id, Web1CustomUserUpdateDto web1CustomUserUpdateDto) {
        CustomUserUpdateDto request = web1CustomUserMapper.mapFromWeb1CustomUserUpdateDto(web1CustomUserUpdateDto);
        CustomUserResponseDto response = customUserCoreFeignClient.updateCustomUser(id, request);
        return web1CustomUserMapper.mapFromCustomUserResponseDto(response);
    }

    @Override
    public void deleteCustomUserById(Long id) {
        customUserCoreFeignClient.deleteCustomUserById(id);
    }

    @Override
    public void deleteCustomUsers(List<Long> ids) {
        customUserCoreFeignClient.deleteCustomUsers(ids);
    }
}
