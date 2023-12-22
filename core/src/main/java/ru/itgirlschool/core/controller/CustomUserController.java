package ru.itgirlschool.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itgirlschool.core.dto.CustomUserCreateDto;
import ru.itgirlschool.core.dto.CustomUserUpdateDto;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class CustomUserController {
    private final CustomUserService customUserService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomUserResponseDTO> getCustomUserById(@PathVariable ("id") Long id) {
        CustomUserResponseDto cu = customUserService.getCustomUserById(id);
        return ResponseEntity.ok(cu);
    }

    @GetMapping
    public ResponseEntity<List<CustomUserResponseDTO>> getCustomUsers() {
        List<CustomUserResponseDTO> cUsers = customUserService.getCustomUsers();
        return ResponseEntity.ok(cUsers);
    }

    @PostMapping
    public ResponseEntity<CustomUserResponseDTO> createCustomUser(@RequestBody CustomUserCreateDto customUserCreateDto) {
        CustomUserResponseDTO createdCustomUser = customUserService.createCustomUser(customUserCreateDto);
        return ResponseEntity.ok(createdCustomUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomUserResponseDTO> updateCustomUser(@PathVariable("id") Long id, @RequestBody CustomUserUpdateDto customUserUpdateDto) {
        CustomUserResponseDTO updatedCustomUser = customUserService.updateCustomUser(id, customUserUpdateDto);
        return ResponseEntity.ok(updatedCustomUser);
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


