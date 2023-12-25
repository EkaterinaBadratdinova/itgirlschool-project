package ru.itgirlschool.web1.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.itgirlschool.web1.dto.CustomUserCreateDto;
import ru.itgirlschool.web1.dto.CustomUserResponseDto;
import ru.itgirlschool.web1.dto.CustomUserUpdateDto;

import java.util.List;

@FeignClient(name = "core", url = "${core.url}")
public interface CustomUserCoreFeignClient {

    @GetMapping(value = "/api/users/{id}")
    CustomUserResponseDto getCustomUserById(@PathVariable("id") Long id);

    @GetMapping(value = "/api/users")
    List<CustomUserResponseDto> getCustomUsers();

    @PostMapping(value = "/api/users", consumes = "application/json")
    CustomUserResponseDto createCustomUser(@RequestBody CustomUserCreateDto customUserCreateDto);

    @PutMapping(value = "/api/users/{id}", consumes = "application/json")
    CustomUserResponseDto updateCustomUser(@PathVariable("id") Long id,
                                           @RequestBody CustomUserUpdateDto customUserUpdateDto);

    @DeleteMapping(value = "/api/users/{id}")
    void deleteCustomUserById(@PathVariable Long id);

    @DeleteMapping(value = "/api/users/batch")
    void deleteCustomUsers(@RequestParam List<Long> ids);
}

