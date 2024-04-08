package br.com.gilpeixoto.cursotestes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gilpeixoto.cursotestes.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {

    Optional<User> findByEmail(String email);

}
