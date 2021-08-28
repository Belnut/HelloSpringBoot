package com.example.HelloSpringBoot.controller;

import com.example.HelloSpringBoot.controller.dto.PostRequestDto;
import com.example.HelloSpringBoot.controller.dto.PostResponseDto;
import com.example.HelloSpringBoot.controller.dto.PostUpdateRequestDto;
import com.example.HelloSpringBoot.controller.dto.ResultDto;
import com.example.HelloSpringBoot.service.HomeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeApiController {
    @Autowired
    HomeApiService service;

    //게시글 GET http://localhost:8080/api/post/{id}
    @GetMapping("/api/post/{id}")
    public ResultDto getPost(@PathVariable Integer id) {
        ResultDto rdto = new ResultDto();
        PostResponseDto rst;
        try {
            rst = service.getPost(id);
            rdto.setCode(HttpStatus.OK.value());
            rdto.setMessage("OK");
            rdto.setData(rst);
        } catch(Exception e) {
            rdto.setCode(HttpStatus.FORBIDDEN.value());
            rdto.setMessage(e.getMessage());
            rdto.setData(null);
        }
        return rdto;
    }

    @PostMapping("/api/post")
    public ResultDto addPost(@RequestBody PostRequestDto dto) {
        ResultDto rdto = new ResultDto();
        try {
            PostResponseDto rst = service.addPost(dto);
            rdto.setCode(HttpStatus.OK.value());
            rdto.setMessage("OK");
            rdto.setData(rst);
        }catch (Exception e) {
            rdto.setCode(HttpStatus.FORBIDDEN.value());
            rdto.setMessage(e.getMessage());
            rdto.setData(null);
        }
        return rdto;
    }

    @DeleteMapping("/api/post/{id}")
    public ResultDto delectPost(@PathVariable Integer id) {
        ResultDto rdto = new ResultDto();
        try {
            PostResponseDto rst = service.deletePost(id);
            rdto.setCode(HttpStatus.OK.value());
            rdto.setMessage("OK");
            rdto.setData(rst);
        }catch (Exception e) {
            rdto.setCode(HttpStatus.FORBIDDEN.value());
            rdto.setMessage(e.getMessage());
            rdto.setData(null);
        }
        return rdto;
    }

    @PutMapping("/api/post")
    public ResultDto updatePost(@RequestBody PostUpdateRequestDto dto) {
        ResultDto rdto = new ResultDto();
        try {
            PostResponseDto rst = service.updatePost(dto);
            rdto.setCode(HttpStatus.OK.value());
            rdto.setMessage("OK");
            rdto.setData(rst);
        }catch (Exception e) {
            rdto.setCode(HttpStatus.FORBIDDEN.value());
            rdto.setMessage(e.getMessage());
            rdto.setData(null);
        }
        return rdto;
    }
}
