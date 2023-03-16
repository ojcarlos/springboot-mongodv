package com.ojcarlos.springmongo.resources;


import com.ojcarlos.springmongo.domain.User;
import com.ojcarlos.springmongo.dto.UserDto;
import com.ojcarlos.springmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserService service;
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity <List<UserDto>> findAll(){
        List<User> list = service.findAll();
        List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public ResponseEntity <UserDto> findById(@PathVariable String id){
        User user = service.findById(id);

        return ResponseEntity.ok().body(new UserDto(user));
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity <UserDto> insert(@RequestBody UserDto userDto){
        User user = service.fromDto(userDto);
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
    public ResponseEntity <Void> delete(@PathVariable String id){
       service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.PUT)
    public ResponseEntity <Void> update(@RequestBody UserDto userDto, @PathVariable String id ){
        User user = service.fromDto(userDto);
        user.setId(id);
        user = service.update(user);
        return ResponseEntity.noContent().build();
    }
}
