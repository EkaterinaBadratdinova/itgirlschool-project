package ru.itgirlschool.web1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itgirlschool.web1.dto.CustomUserDto;
import ru.itgirlschool.web1.dto.mapper.Web1CustomUserMapper;
import ru.itgirlschool.web1.entity.CustomUser;
import ru.itgirlschool.web1.feign.CustomUserCoreFeignClient;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final CustomUserCoreFeignClient customUserCoreFeignClient;

    private final Web1CustomUserMapper web1CustomUserMapper;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        CustomUserDto response = customUserCoreFeignClient.getCustomUserByLogin(login);
        CustomUser customUser = web1CustomUserMapper.mapFromCustomUserDto(response);
        return CustomUserDetailsImpl.build(customUser);
    }
}
