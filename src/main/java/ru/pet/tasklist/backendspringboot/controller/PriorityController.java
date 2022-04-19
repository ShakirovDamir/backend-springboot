package ru.pet.tasklist.backendspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pet.tasklist.backendspringboot.entity.Priority;
import ru.pet.tasklist.backendspringboot.repository.PriorityRepository;

import java.util.List;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    private PriorityRepository priorityRepository;

    public PriorityController(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @GetMapping("/test")
    public List<Priority> test(){
        List<Priority> list = priorityRepository.findAll();
        return list;
    }
}
