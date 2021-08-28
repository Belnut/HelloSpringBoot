package com.example.HelloSpringBoot.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponseDto {
    private Integer id;
    private String subject;
    private String context;
}
