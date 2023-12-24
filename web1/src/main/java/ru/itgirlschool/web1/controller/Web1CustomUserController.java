package ru.itgirlschool.web1.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itgirlschool.web1.service.Web1CustomUserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/web1")
public class Web1CustomUserController {

    private final Web1CustomUserService web1CustomUserService;

    @GetMapping("/{id}")
    public ResponseEntity<Web1CustomUserResponseDto> getCustomUserById(@PathVariable("id") Long id) {
        Web1CustomUserResponseDto response = web1CustomUserService.getCustomUserById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Web1CustomUserResponseDto>> getCustomUsers() {
        List<Web1CustomUserResponseDto> customUsers = web1CustomUserService.getCustomUsers();
        return ResponseEntity.ok(customUsers);
    }

    @PostMapping
    public ResponseEntity<Web1CustomUserResponseDto> createCustomUser(@RequestBody @Valid Web1CustomUserCreateDto web1CustomUserCreateDto) {
        Web1CustomUserResponseDto response = web1CustomUserService.createCustomUser(web1CustomUserCreateDto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Web1CustomUserResponseDto> updateCustomUser(@PathVariable("id") Long id,
                                                                      @RequestBody @Valid Web1CustomUserUpdateDto web1customUserUpdateDto) {
        Web1CustomUserResponseDto response = web1CustomUserService.updateCustomUser(id, web1customUserUpdateDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomUserById(@PathVariable Long id) {
        web1CustomUserService.deleteCustomUserById(id);
        return ResponseEntity.ok();
    }

    @DeleteMapping("/batch")
    public ResponseEntity<Void> deleteCustomUsers(@RequestParam List<Long> ids) {
        web1CustomUserService.deleteCustomUsers(ids);
        return ResponseEntity.ok();
    }
}