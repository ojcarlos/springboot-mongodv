package com.ojcarlos.springmongo.services;

import com.ojcarlos.springmongo.domain.Post;
import com.ojcarlos.springmongo.domain.User;
import com.ojcarlos.springmongo.dto.UserDto;
import com.ojcarlos.springmongo.repository.PostRepository;
import com.ojcarlos.springmongo.repository.UserRepository;
import com.ojcarlos.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
