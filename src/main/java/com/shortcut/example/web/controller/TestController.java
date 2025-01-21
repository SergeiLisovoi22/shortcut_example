package com.shortcut.example.web.controller;

import com.shortcut.example.service.UserService;
import com.shortcut.example.web.controller.model.ResponseUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseUserDto> getUser(@PathVariable Long userId) {
        log.info("TESTCONTROLLER INSIDE GET INFO");
        log.debug("TESTCONTROLLER INSIDE GET DEBUG");
        return ResponseEntity.ok(userService.getUser(userId));
    }
}
