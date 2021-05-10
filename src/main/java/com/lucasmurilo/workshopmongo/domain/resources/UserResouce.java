package com.lucasmurilo.workshopmongo.domain.resources;

import com.lucasmurilo.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value ="/users")
public class UserResouce {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User maria = new User(null, "Maria Silvia", "maria@gmail.com");
        User alex = new User(null, "Alex Pereira", "alex@hotmail.com");
        User lucas = new User(null, "Lucas Murilo", "lucas@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex, lucas));
        return ResponseEntity.ok().body(list);
    }

}
