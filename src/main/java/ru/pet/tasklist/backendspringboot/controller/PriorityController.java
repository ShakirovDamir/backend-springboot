package ru.pet.tasklist.backendspringboot.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pet.tasklist.backendspringboot.entity.Category;
import ru.pet.tasklist.backendspringboot.entity.Priority;
import ru.pet.tasklist.backendspringboot.repository.PriorityRepository;
import ru.pet.tasklist.backendspringboot.search.CategorySearchValues;
import ru.pet.tasklist.backendspringboot.search.PrioritySearchValues;
import ru.pet.tasklist.backendspringboot.util.MyLogger;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    private PriorityRepository priorityRepository;

    public PriorityController(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @GetMapping("/all")
    public List<Priority> findAll(){
        MyLogger.showMethodName("PriorityController: findAll() --------------------------------------");
        return priorityRepository.findAllByOrderByIdAsc();
    }

    @PostMapping("/add")
    public ResponseEntity<Priority> add(@RequestBody Priority priority){
        MyLogger.showMethodName("PriorityController: add() --------------------------------------");
        if(priority.getId() != null && priority.getId() != 0){
            return new ResponseEntity("redundant param: id must be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if(priority.getTitle() == null || priority.getTitle().trim().length() == 0){
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }
        if(priority.getColor() == null || priority.getColor().trim().length() == 0){
            return new ResponseEntity("missed param: color", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(priorityRepository.save(priority));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Priority priority){
        MyLogger.showMethodName("PriorityController: update() --------------------------------------");
        if(priority.getId() == null || priority.getId() == 0){
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);
        }
        if(priority.getTitle() == null || priority.getTitle().trim().length() == 0){
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }
        if(priority.getColor() == null || priority.getColor().trim().length() == 0){
            return new ResponseEntity("missed param: color", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(priorityRepository.save(priority));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Priority> findById(@PathVariable Long id){
        MyLogger.showMethodName("PriorityController: findById() --------------------------------------");
        Priority priority = null;
        try{
            priority = priorityRepository.findById(id).get();
        } catch(NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("id=" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(priority);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        MyLogger.showMethodName("PriorityController: delete() --------------------------------------");
        try{
            priorityRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return new ResponseEntity("id=" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Priority>> search(@RequestBody PrioritySearchValues prioritySearchValues){
        MyLogger.showMethodName("PriorityController: search() --------------------------------------");
        return ResponseEntity.ok(priorityRepository.findByTitle(prioritySearchValues.getText()));
    }
}

