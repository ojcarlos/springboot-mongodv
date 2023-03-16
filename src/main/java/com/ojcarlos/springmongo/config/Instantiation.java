package com.ojcarlos.springmongo.config;

import com.ojcarlos.springmongo.domain.Post;
import com.ojcarlos.springmongo.domain.User;
import com.ojcarlos.springmongo.repository.PostRepository;
import com.ojcarlos.springmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post p1 = new Post(null, sdf.parse("21/03/2021"), "Partiu viagem!", "Vou viajar para São Paulo. Abraços!", maria);

        Post p2 = new Post(null, sdf.parse("23/03/2021"), "Bom dia!", "Acordei feliz", maria);

        postRepository.saveAll(Arrays.asList(p1,p2));


        userRepository.saveAll(Arrays.asList(maria, alex, bob));


    }
}
