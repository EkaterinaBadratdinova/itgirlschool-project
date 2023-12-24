package ru.itgirlschool.web1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ru.itgirlschool.web1.feign.CustomUserCoreFeignClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Web1CustomUserServiceImpl implements Web1CustomUserService {

    private final CustomUserCoreFeignClient customUserCoreFeignClient;
    private final CustomUserMapper customUserMapper;

    @Override
    public Web1CustomUserResponseDto getCustomUserById(Long id) {
        CustomUserResponseDto response = customUserCoreFeignClient.getCustomUserById(id);
        //замаппить CustomUserResponseDto в Web1CustomUserResponseDto
        //создать дто и метод в маппере
        return customUserMapper.mapToWeb1CustomUserResponseDto(response);
    }

    @Override
    public List<Web1CustomUserResponseDto> getCustomUsers() {
        List<CustomUserResponseDto> customUsers = customUserCoreFeignClient.getCustomUsers();
        return customUsers.stream()
                .map(customUser -> customUserMapper.mapToWeb1CustomUserResponseDto(customUser))
                .collect(Collectors.toList());
    }

    @Override
    public Web1CustomUserResponseDto createCustomUser(Web1CustomUserCreateDto web1CustomUserCreateDto) {
        //замаппить Web1CustomUserCreateDto в CustomUserCreateDto
        //создать дто и метод в маппере
        CustomUserCreateDto request = customUserMapper.mapToCustomUserCreateDto(web1CustomUserCreateDto);
        CustomUserResponseDto response = customUserCoreFeignClient.createCustomUser(request);
        return customUserMapper.mapToWeb1CustomUserResponseDto(response);
    }

    @Override
    public Web1CustomUserResponseDto updateCustomUser(Long id, Web1CustomUserUpdateDto web1CustomUserUpdateDto) {
        //замаппить Web1CustomUserUpdateDto в CustomUserUpdateDto
        //создать дто и метод в маппере
        CustomUserUpdateDto request = customUserMapper.mapToCustomUserUpdateDto(web1CustomUserUpdateDto);
        CustomUserResponseDto response = customUserCoreFeignClient.updateCustomUser(id, request);
        return customUserMapper.mapToWeb1CustomUserResponseDto(response);
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
