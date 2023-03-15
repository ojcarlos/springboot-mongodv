package com.ojcarlos.springmongo.services;

import com.ojcarlos.springmongo.domain.User;
import com.ojcarlos.springmongo.dto.UserDto;
import com.ojcarlos.springmongo.repository.UserRepository;
import com.ojcarlos.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    public List<User> findAll(){
        return repo.findAll();

    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user){
        return repo.insert(user);
    }

    public void delete(String id){

        findById(id);
        repo.deleteById(id);
    }

    public User fromDto (UserDto userDto){
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }
}
