package ru.itgirlschool.core.service;

import org.springframework.stereotype.Service;
import ru.itgirlschool.core.dto.CustomUserCreateDto;
import ru.itgirlschool.core.dto.CustomUserRequestDto;
import ru.itgirlschool.core.dto.CustomUserResponseDto;
import ru.itgirlschool.core.dto.CustomUserUpdateDto;
import ru.itgirlschool.core.dto.mapper.CustomUserMapper;
import ru.itgirlschool.core.entity.CustomUser;
import ru.itgirlschool.core.repository.CustomUserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserServiceImpl implements CustomUserService {

    private final CustomUserRepository customUserRepository;
    private final CustomUserMapper customUserMapper;

    public CustomUserServiceImpl(CustomUserRepository customUserRepository, CustomUserMapper customUserMapper) {
        this.customUserRepository = customUserRepository;
        this.customUserMapper = customUserMapper;
    }

    @Override
    public CustomUserResponseDto getCustomUserById(Long id) {
        CustomUser customUser = customUserRepository.findById(id).orElseThrow();
        return customUserMapper.mapToResponseUserDto(customUser);
    }

    @Override
    public List<CustomUserResponseDto> getCustomUsers() {
        List<CustomUser> customUsers = customUserRepository.findAll();
        return customUsers.stream()
                .map(customUser -> customUserMapper.mapToResponseUserDto(customUser))
                .collect(Collectors.toList());
    }

    @Override
    public CustomUserResponseDto createCustomUser(CustomUserRequestDto customUserDto) {
        return null;
    }

    @Override
    public CustomUserResponseDto updateCustomUser(Long id, CustomUserRequestDto customUserDto) {
        return null;
    }

    @Override
    public CustomUserResponseDto createCustomUser(CustomUserCreateDto customUserCreateDto) {
        CustomUser customUser = customUserMapper.mapFromUserCreateDto(customUserCreateDto);
        CustomUser savedUser = customUserRepository.save(customUser);
        return customUserMapper.mapToResponseUserDto(savedUser);
    }

    @Override
    public CustomUserResponseDto updateCustomUser(Long id, CustomUserUpdateDto customUserUpdateDto) {
        CustomUser customUser = customUserRepository.findById(id).orElseThrow();
        customUser.setFirstName(customUserUpdateDto.getFirstName());
        CustomUser.setLastName(customUserUpdateDto.getLastName());
        CustomUser.setBirthday(customUserUpdateDto.getBirthday());
        CustomUser.setAge(customUserUpdateDto.getAge());
        CustomUser.setEmail(customUser.getEmail());
        CustomUser.setPhone(customUser.getPhone());
        CustomUser.setLogin(customUser.getLogin());
        CustomUser.setPassword(customUser.getPassword());
        CustomUser updatedUser = customUserRepository.save(customUser);
        return customUserMapper.mapToResponseUserDto(updatedUser);
    }

    @Override
    public void deleteCustomUser(Long id) {
        CustomUser customUser = customUserRepository.findById(id).orElseThrow();
        customUserRepository.delete(customUser);
    }

    @Override
    public void deleteCustomUsers(List<Long> ids) {
        List<CustomUser> customUsers = customUserRepository.findAllById(ids);
        customUserRepository.deleteAll(customUsers);
    }
}