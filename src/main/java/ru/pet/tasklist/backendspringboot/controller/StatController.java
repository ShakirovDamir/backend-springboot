package ru.pet.tasklist.backendspringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.pet.tasklist.backendspringboot.entity.Stat;
import ru.pet.tasklist.backendspringboot.repository.StatRepository;
import ru.pet.tasklist.backendspringboot.util.MyLogger;

@RestController
public class StatController {

    private final StatRepository statRepository;

    public StatController(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    private final Long defauldId = 1L;

    public ResponseEntity<Stat> findById(){
        MyLogger.showMethodName("StatController: findById() --------------------------------------");
        return ResponseEntity.ok(statRepository.findById(defauldId).get());
    }
}
