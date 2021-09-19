package br.com.devsuperior.hruser.resources;

import br.com.devsuperior.hruser.entities.User;
import br.com.devsuperior.hruser.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserResource {

    private UserRepository repository;

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id){ return repository.findById(id);}

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        Optional<User> byEmail = repository.findByEmail(email);
        return byEmail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
