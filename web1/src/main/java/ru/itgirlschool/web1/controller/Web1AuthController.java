package ru.itgirlschool.web1.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.itgirlschool.web1.dto.*;
import ru.itgirlschool.web1.dto.mapper.Web1CustomUserMapper;
import ru.itgirlschool.web1.feign.CustomUserCoreFeignClient;
import ru.itgirlschool.web1.security.JwtUtil;
import ru.itgirlschool.web1.service.CustomUserDetailsImpl;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/web1/auth")
public class Web1AuthController {

    private final AuthenticationManager authenticationManager;

    private final CustomUserCoreFeignClient customUserCoreFeignClient;

    private final JwtUtil jwtUtil;

    private final Web1CustomUserMapper mapper;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody SignInCustomUserDto signInCustomUserDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInCustomUserDto.getLogin(), signInCustomUserDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateJwtToken(authentication);

        CustomUserDetailsImpl userDetails = (CustomUserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody Web1CustomUserCreateDto web1CustomUserCreateDto) {
        CustomUserCreateDto customUserCreateDto = mapper.mapFromWeb1CustomUserCreateDto(web1CustomUserCreateDto);
        customUserCoreFeignClient.createCustomUser(customUserCreateDto);
        return ResponseEntity.ok("User registered successfully!");
    }
}
