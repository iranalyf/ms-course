package br.com.devsuperior.hroauth.resources;

import br.com.devsuperior.hroauth.dto.User;
import br.com.devsuperior.hroauth.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserResource {

    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        User byEmail = userService.findByEmail(email);
        return ResponseEntity.ok(byEmail);
    }
}
