package ru.pet.tasklist.backendspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.pet.tasklist.backendspringboot.entity.Stat;

@Repository
public interface StatRepository extends CrudRepository<Stat, Long> {
}
