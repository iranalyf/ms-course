package br.com.devsuperior.hrworker.resources;

import br.com.devsuperior.hrworker.entities.Worker;
import br.com.devsuperior.hrworker.repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
@AllArgsConstructor
@Slf4j
public class WorkerResource {

    private WorkerRepository workerRepository;

    private Environment env;

    @GetMapping(value = "/configs")
    public ResponseEntity<?> getConfigs(){
        log.info("CONFIG="+ env.getProperty("test.config"));
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(workerRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        log.info("PORT=" + env.getProperty("local.server.port"));
        Optional<Worker> byId = workerRepository.findById(id);
        return byId.isPresent() ? ResponseEntity.ok(byId.get()) : ResponseEntity.notFound().build();
    }
}
