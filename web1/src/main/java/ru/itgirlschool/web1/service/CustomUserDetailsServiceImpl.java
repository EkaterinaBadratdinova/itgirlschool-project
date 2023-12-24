package ru.itgirlschool.web1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itgirlschool.web1.dto.Web1CustomUserUpdateDto;
import ru.itgirlschool.web1.entity.CustomUser;
import ru.itgirlschool.web1.feign.CustomUserCoreFeignClient;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final CustomUserCoreFeignClient customUserCoreFeignClient;

    //реализовать маппер
    //реализовать DTO
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Web1CustomUserUpdateDto> customUserResponseDtoOptional = customUserCoreFeignClient.getUserByLogin(login);
        if (customUserResponseDtoOptional.isEmpty()) {
            throw new UsernameNotFoundException("User Not Found with login: " + login);
        } else {
            Web1CustomUserUpdateDto customUserResponseDto = customUserResponseDtoOptional.get();
            CustomUser customUser = mapToCustomUser(customUserResponseDto);
            return CustomUserDetailsImpl.build(customUser);
        }
    }
}
