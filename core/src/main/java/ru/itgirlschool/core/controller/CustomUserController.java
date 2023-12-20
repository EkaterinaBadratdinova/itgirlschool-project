package ru.itgirlschool.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itgirlschool.core.dto.CustomUserCreateDto;
import ru.itgirlschool.core.dto.CustomUserUpdateDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomUserController {
    private final CustomUserService customUserService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomUserResponseDTO> getCustomUserById(@PathVariable Long id) {
        customUserService.getCustomUserById(id);
        return ResponseEntity.ok()
                .build();
    }

    @GetMapping
    public ResponseEntity<List<CustomUserResponseDTO>> getCustomUsers() {
        List<CustomUserResponseDTO> customUsers = customUserService.getCustomUsers();
        return ResponseEntity.ok(customUsers);
    }

    @PostMapping
    public ResponseEntity<CustomUserCreateDto> createCustomUser(@RequestBody CustomUserCreateDto customUserCreateDto) {
        customUserService.createCustomUser(customUserCreateDto);
        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomUserUpdateDto> updateCustomUser(@PathVariable Long id, @RequestBody CustomUserUpdateDto customUserUpdateDto) {
        customUserService.updateCustomUser(id, customUserUpdateDto);
        return ResponseEntity.ok()
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomUser(@PathVariable Long id) {
        customUserService.deleteCustomUser(id);
        return ResponseEntity.ok()
                .build();
    }

    @DeleteMapping("/batch")
    public ResponseEntity<Void> deleteCustomUser(@RequestParam List<Long> ids) {
        customUserService.deleteCustomUsers(ids);
        return ResponseEntity.ok()
                .build();
    }
}


