package com.lucasmurilo.workshopmongo.repository;

import com.lucasmurilo.workshopmongo.domain.Post;
import com.lucasmurilo.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{'title': {regex: ?0, $options: 'i'}}")
    List<Post> searchTitle(String msg);
    List <Post> findByTitleContainingIgnoreCase(String text);



}
