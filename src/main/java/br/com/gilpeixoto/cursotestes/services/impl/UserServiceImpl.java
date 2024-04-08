package br.com.gilpeixoto.cursotestes.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gilpeixoto.cursotestes.domain.User;
import br.com.gilpeixoto.cursotestes.domain.dto.UserDTO;
import br.com.gilpeixoto.cursotestes.repositories.UserRepository;
import br.com.gilpeixoto.cursotestes.services.UserService;
import br.com.gilpeixoto.cursotestes.services.exceptions.DataIntegrityViolationException;
import br.com.gilpeixoto.cursotestes.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByIdEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    private void findByIdEmail(UserDTO obj) {
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if (user.isPresent()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
            
        }
    }

}
