package com.ojcarlos.springmongo.resources;


import com.ojcarlos.springmongo.domain.Post;
import com.ojcarlos.springmongo.domain.User;
import com.ojcarlos.springmongo.dto.UserDto;
import com.ojcarlos.springmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

    @Autowired
    private PostService service;


    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public ResponseEntity <Post> findById(@PathVariable String id){
        Post post = service.findById(id);

        return ResponseEntity.ok().body(post);
    }


}
