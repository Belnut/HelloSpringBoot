package com.example.HelloSpringBoot.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUpdateRequestDto {
    Integer id;
    String subject;
    String context;
}
