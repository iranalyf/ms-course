package br.com.devsuperior.hroauth.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;

    private Set<Role> roles;
}
