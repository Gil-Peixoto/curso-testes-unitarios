package br.com.gilpeixoto.cursotestes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_user")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    private Integer id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;

}
