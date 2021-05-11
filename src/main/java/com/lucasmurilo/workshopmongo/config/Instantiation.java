package com.lucasmurilo.workshopmongo.config;

import com.lucasmurilo.workshopmongo.domain.Post;
import com.lucasmurilo.workshopmongo.domain.User;
import com.lucasmurilo.workshopmongo.dto.AuthorDto;
import com.lucasmurilo.workshopmongo.repository.PostRepository;
import com.lucasmurilo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.awt.desktop.AboutHandler;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Configuration
public class Instantiation implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    
    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2021" ), "Partiu viagem", "Vou viajar para São Paulo", new AuthorDto(maria));
        Post post2 = new Post(null, sdf.parse("21/04/2021" ), "Bora trabalhar!", "trabalhar, trabalhar!", new AuthorDto(alex));

        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}
