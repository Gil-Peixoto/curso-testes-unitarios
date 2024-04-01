package br.com.gilpeixoto.cursotestes.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gilpeixoto.cursotestes.domain.User;
import br.com.gilpeixoto.cursotestes.repositories.UserRepository;
import br.com.gilpeixoto.cursotestes.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElse(null);
    }

}
