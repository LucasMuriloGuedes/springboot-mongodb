package com.lucasmurilo.workshopmongo.service;

import com.lucasmurilo.workshopmongo.domain.Post;
import com.lucasmurilo.workshopmongo.domain.User;
import com.lucasmurilo.workshopmongo.dto.UserDTO;
import com.lucasmurilo.workshopmongo.repository.PostRepository;
import com.lucasmurilo.workshopmongo.repository.UserRepository;
import com.lucasmurilo.workshopmongo.service.exception.ObjectNotFoundException;
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