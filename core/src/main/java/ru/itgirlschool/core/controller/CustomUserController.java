package ru.itgirlschool.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itgirlschool.core.dto.CustomUserCreateDto;
import ru.itgirlschool.core.dto.CustomUserResponseDto;
import ru.itgirlschool.core.dto.CustomUserUpdateDto;
import ru.itgirlschool.core.service.CustomUserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class CustomUserController {
    private final CustomUserService customUserService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomUserResponseDto> getCustomUserById(@PathVariable ("id") Long id) {
        CustomUserResponseDto response = customUserService.getCustomUserById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CustomUserResponseDto>> getCustomUsers() {
        List<CustomUserResponseDto> responseList = customUserService.getCustomUsers();
        return ResponseEntity.ok(responseList);
    }

    @PostMapping
    public ResponseEntity<CustomUserResponseDto> createCustomUser(@RequestBody CustomUserCreateDto customUserCreateDto) throws Exception {
        CustomUserResponseDto createdCustomUser = customUserService.createCustomUser(customUserCreateDto);
        return ResponseEntity.ok(createdCustomUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomUserResponseDto> updateCustomUser(@PathVariable("id") Long id, @RequestBody CustomUserUpdateDto customUserUpdateDto) throws Exception {
        CustomUserResponseDto updatedCustomUser = customUserService.updateCustomUser(id, customUserUpdateDto);
        return ResponseEntity.ok(updatedCustomUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomUserById(@PathVariable("id") Long id) {
        customUserService.deleteCustomUser(id);
        return ResponseEntity.ok()
                .build();
    }

    @DeleteMapping("/batch")
    public ResponseEntity<Void> deleteCustomUsers(@RequestParam List<Long> ids) {
        customUserService.deleteCustomUsers(ids);
        return ResponseEntity.ok()
                .build();
    }
}


