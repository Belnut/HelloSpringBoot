package com.example.HelloSpringBoot.service;

import com.example.HelloSpringBoot.controller.dto.PostRequestDto;
import com.example.HelloSpringBoot.controller.dto.PostResponseDto;
import com.example.HelloSpringBoot.controller.dto.PostUpdateRequestDto;
import com.example.HelloSpringBoot.domain.Post;
import com.example.HelloSpringBoot.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class HomeApiService {
    @Autowired
    HomeRepository repository;

    @Transactional
    public PostResponseDto getPost(int id) throws Exception{
        PostResponseDto dto = new PostResponseDto();
        Post post = repository.findById(id)
                .orElseThrow(() -> new Exception("not found post"));

        dto.setId(post.getId());
        dto.setSubject(post.getSubject());
        dto.setContext(post.getContext());
        return dto;
    }

    @Transactional
    public PostResponseDto addPost(PostRequestDto dto) throws Exception {
        Post post = new Post();
        post.setSubject(dto.getSubject());
        post.setContext(dto.getContext());
        post = repository.save(post);

        if (post == null)
            throw new Exception("save fail");

        PostResponseDto rst = new PostResponseDto();
        rst.setId(post.getId());
        rst.setSubject(post.getSubject());
        rst.setContext(post.getContext());

        return rst;
    }

    @Transactional
    public PostResponseDto deletePost(Integer id) throws Exception{
        Post post = repository.findById(id)
                .orElseThrow(() -> new Exception("not found post"));
        repository.delete(post);

        PostResponseDto rst = new PostResponseDto();
        rst.setId(post.getId());
        rst.setSubject(post.getSubject());
        rst.setContext(post.getContext());
        return rst;
    }

    @Transactional
    public PostResponseDto updatePost(PostUpdateRequestDto dto) throws Exception {
        Post post = repository.findById(dto.getId())
                .orElseThrow(() -> new Exception("not found post"));
        post.setSubject(dto.getSubject());
        post.setContext(dto.getContext());
        post = repository.save(post);
        if (post == null)
            throw new Exception("");

        PostResponseDto rst = new PostResponseDto();
        rst.setId(post.getId());
        rst.setSubject(post.getSubject());
        rst.setContext(post.getContext());

        return rst;
    }
}
