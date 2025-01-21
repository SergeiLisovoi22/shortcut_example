package com.shortcut.example.web.controller;

import com.shortcut.example.service.UserService;
import com.shortcut.example.web.controller.model.RequestUserDto;
import com.shortcut.example.web.controller.model.ResponseUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseUserDto> getUser(@PathVariable Long userId) {
        log.info("USERCONTROLLER INSIDE GET INFO");
        log.debug("USERCONTROLLER INSIDE GET DEBUG");
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @GetMapping
    public ResponseEntity<List<ResponseUserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ResponseUserDto> updateUser(@PathVariable Long userId, @RequestBody RequestUserDto dto) {
        return ResponseEntity.ok(userService.updateUser(userId, dto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public ResponseEntity<ResponseUserDto> createUser(@RequestBody RequestUserDto dto) {
        return  ResponseEntity.ok(userService.createUser(dto));
    }
}
