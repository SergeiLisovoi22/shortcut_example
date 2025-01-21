package com.shortcut.example.web.controller.model;

import lombok.Data;

@Data
public class ResponseUserDto {
    private Long id;
    private String name;
    private String surname;
    private String description;
}
