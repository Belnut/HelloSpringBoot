package com.example.HelloSpringBoot.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultDto {
    Integer code;
    String message;
    Object data;
}
