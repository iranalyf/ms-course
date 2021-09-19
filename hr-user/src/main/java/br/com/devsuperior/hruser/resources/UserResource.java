package br.com.devsuperior.hruser.resources;

import br.com.devsuperior.hruser.entities.User;
import br.com.devsuperior.hruser.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserResource {

    private UserRepository repository;

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id){ return repository.findById(id);}
}
