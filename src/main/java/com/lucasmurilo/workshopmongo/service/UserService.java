package com.lucasmurilo.workshopmongo.service;

import com.lucasmurilo.workshopmongo.domain.User;
import com.lucasmurilo.workshopmongo.dto.UserDTO;
import com.lucasmurilo.workshopmongo.repository.UserRepository;
import com.lucasmurilo.workshopmongo.service.exception.ObjectNotFoundException;
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

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User update(User user){
        User objUser = findById(user.getId());
        updateData(objUser, user);
        return repo.save(objUser);

    }

    private void updateData(User objUser, User user) {
        objUser.setName(user.getName());
        objUser.setEmail(user.getEmail());
    }
}
