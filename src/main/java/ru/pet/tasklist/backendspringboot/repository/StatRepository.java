package ru.pet.tasklist.backendspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pet.tasklist.backendspringboot.entity.Stat;

public interface StatRepository extends CrudRepository<Stat, Long> {
}
