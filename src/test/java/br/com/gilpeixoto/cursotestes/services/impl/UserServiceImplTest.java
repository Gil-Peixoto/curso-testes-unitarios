package br.com.gilpeixoto.cursotestes.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gilpeixoto.cursotestes.domain.User;
import br.com.gilpeixoto.cursotestes.domain.dto.UserDTO;
import br.com.gilpeixoto.cursotestes.repositories.UserRepository;
import br.com.gilpeixoto.cursotestes.services.exceptions.ObjectNotFoundException;

@SpringBootTest
public class UserServiceImplTest {

    private static final Integer ID = 1;

    private static final String NAME = "Gil";

    private static final String EMAIL = "gil@gmail.com";

    private static final String PASSWORD = "gil123";


    @InjectMocks     //  <--Serve para injetar uma instância real
    private UserServiceImpl service;

    @Mock            //  <--Serve para injetar uma instância "fake", onde eu não preciso acessar o banco de dados na prática
    private UserRepository repository;

    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDTO userDTO;
    private Optional<User> optionalUser;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void create() {

    }

    @Test
    void delete() {

    }

    @Test
    void whenFindAllThenReturnAnListOfUser() {

        when(repository.findAll()).thenReturn(List.of(user));

        List<User> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(User.class, response.get(0).getClass());
        assertEquals(1, response.get(0).getId());

    }

    @Test
    void whenfindByIdThenReturnAnUserInstance() {   //Buscar por Id e retorna um usuario
        
        when(repository.findById(anyInt())).thenReturn(optionalUser);

        User response = service.findById(ID);

        assertNotNull(response);

        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {

        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado"));

        try{
            service.findById(ID);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Objeto não encontrado", ex.getMessage());
        }
    }

    @Test
    void update() {

    }

    private void startUser() {
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));
    }
}
