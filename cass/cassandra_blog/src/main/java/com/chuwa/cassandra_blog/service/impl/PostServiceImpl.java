package com.chuwa.cassandra_blog.service.impl;

import com.chuwa.cassandra_blog.dao.Repository;
import com.chuwa.cassandra_blog.entity.Post;
import com.chuwa.cassandra_blog.exception.ResourceNotFoundException;
import com.chuwa.cassandra_blog.payload.PostDto;
import com.chuwa.cassandra_blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private Repository repository;

    public PostServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);

        Post savedPost = repository.save(post);

        return mapToDto(savedPost);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = repository.findAll();
        List<PostDto> postDtos = posts
                .stream()
                .map(post -> mapToDto(post))
                .collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(UUID id) {
        Post post = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, UUID id) {
        Post post = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatePost = repository.save(post);
        return mapToDto(updatePost);
    }

    @Override
    public void deletePostById(UUID id) {
        Post post = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        repository.delete(post);

    }

    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }

    private PostDto mapToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }
}
