package ru.itgirlschool.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itgirlschool.core.dto.CustomUserCreateDto;
import ru.itgirlschool.core.dto.CustomUserDto;
import ru.itgirlschool.core.dto.CustomUserResponseDto;
import ru.itgirlschool.core.dto.CustomUserUpdateDto;
import ru.itgirlschool.core.dto.mapper.CustomUserMapper;
import ru.itgirlschool.core.entity.CustomUser;
import ru.itgirlschool.core.entity.Role;
import ru.itgirlschool.core.entity.RoleType;
import ru.itgirlschool.core.repository.CustomUserRepository;
import ru.itgirlschool.core.repository.RoleRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserServiceImpl implements CustomUserService {

    private final CustomUserRepository customUserRepository;
    private final RoleRepository roleRepository;
    private final CustomUserMapper customUserMapper;
    private final PasswordEncoder encoder;

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
    public CustomUserResponseDto createCustomUser(CustomUserCreateDto customUserCreateDto) throws Exception {
        if (customUserRepository.existsByEmail(customUserCreateDto.getEmail())) {
            throw new Exception("User with such email already exists. Enter another email.");
        }
        if (customUserRepository.existsByPhone(customUserCreateDto.getPhone())) {
            throw new Exception("User with such phone already exists. Enter another phone.");
        }
        if (customUserRepository.existsByLogin(customUserCreateDto.getLogin())) {
            throw new Exception("User with such login already exists. Enter another login.");
        }
        CustomUser customUser = customUserMapper.mapFromUserCreateDto(customUserCreateDto);
        customUser.setPassword(encoder.encode(customUserCreateDto.getPassword()));
        Optional<Role> roleOptional = roleRepository.findByRole(RoleType.ROLE_USER);
        if (roleOptional.isPresent()) {
            Role role = roleOptional.get();
            customUser.setRoles(Collections.singleton(role));
        } else {
            throw new Exception("The role not present.");
        }
        CustomUser savedUser = customUserRepository.save(customUser);
        return customUserMapper.mapToResponseUserDto(savedUser);
    }

    @Override
    public CustomUserResponseDto updateCustomUser(Long id, CustomUserUpdateDto customUserUpdateDto) throws Exception {
        CustomUser customUser = customUserRepository.findById(id).orElseThrow();
        customUser.setFirstName(customUserUpdateDto.getFirstName());
        customUser.setLastName(customUserUpdateDto.getLastName());
        customUser.setBirthday(customUserUpdateDto.getBirthday());
        customUser.setAge(customUserUpdateDto.getAge());
        if (customUser.getEmail().equals(customUserUpdateDto.getEmail())) {
            customUser.setEmail(customUser.getEmail());
        } else {
            if (customUserRepository.existsByEmail(customUserUpdateDto.getEmail())) {
                throw new Exception("User with such email already exists. Enter another email.");
            } else {
                customUser.setEmail(customUser.getEmail());
            }
        }
        if (customUser.getPhone().equals(customUserUpdateDto.getPhone())) {
            customUser.setPhone(customUser.getPhone());
        } else {
            if (customUserRepository.existsByPhone(customUserUpdateDto.getPhone())) {
                throw new Exception("User with such phone already exists. Enter another phone.");
            } else {
                customUser.setPhone(customUser.getPhone());
            }
        }
        if (customUser.getLogin().equals(customUserUpdateDto.getLogin())) {
            customUser.setLogin(customUser.getLogin());
        } else {
            if (customUserRepository.existsByLogin(customUserUpdateDto.getLogin())) {
                throw new Exception("User with such login already exists. Enter another login.");
            } else {
                customUser.setLogin(customUser.getLogin());
            }
        }
        if (customUserUpdateDto.getIsChangePassword()) {
            customUser.setPassword(encoder.encode(customUser.getPassword()));
        }
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

    @Override
    public CustomUserDto getByLogin(String login) {
        CustomUser customUser = customUserRepository.findByLogin(login).orElseThrow();
        return customUserMapper.mapToUserDto(customUser);
    }
}