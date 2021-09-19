package br.com.devsuperior.hroauth.services;

import br.com.devsuperior.hroauth.dto.User;
import br.com.devsuperior.hroauth.feignclients.UserFeignClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private UserFeignClient userFeignClient;

    public User findByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();
        if(user == null){
            log.info("Email not foud"+ email);
            throw new IllegalArgumentException("E-Mail notFound");
        }
        log.info("email found"+ email);
        return user;
    }
}
