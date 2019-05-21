package com.pulmuone.webservice.service;

import com.pulmuone.webservice.domain.posts.PostsRepository;
import com.pulmuone.webservice.dto.posts.PostsSaveRequestDto;
import com.pulmuone.webservice.dto.posts.posts.PostsMainResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Controller에서 Dto.toEntity를 통해서 바로 전달해도 되는데 굳이 Service에서 Dto를 받는 이유
 * Controller와 Service 의 역할을 분리
 */
@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)     //new == posts -> new PostsMainResponseDto(posts)
                .collect(Collectors.toList());
    }
}