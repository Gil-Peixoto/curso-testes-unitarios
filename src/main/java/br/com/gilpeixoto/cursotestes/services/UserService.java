package br.com.gilpeixoto.cursotestes.services;

import java.util.List;

import br.com.gilpeixoto.cursotestes.domain.User;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

    

}
