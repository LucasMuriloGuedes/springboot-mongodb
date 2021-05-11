package com.lucasmurilo.workshopmongo.config;

import com.lucasmurilo.workshopmongo.domain.Post;
import com.lucasmurilo.workshopmongo.domain.User;
import com.lucasmurilo.workshopmongo.dto.AuthorDto;
import com.lucasmurilo.workshopmongo.dto.CommentDTO;
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
        Post post2 = new Post(null, sdf.parse("21/04/2021" ), "Bora trabalhar!", "trabalhar, trabalhar!", new AuthorDto(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano", sdf.parse("25/03/2021"), new AuthorDto(alex));
        CommentDTO c2 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("25/04/2021"), new AuthorDto(maria));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/05/2021"), new AuthorDto(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));


        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPost().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
