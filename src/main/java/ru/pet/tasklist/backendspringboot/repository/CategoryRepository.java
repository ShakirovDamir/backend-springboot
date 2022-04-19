package ru.pet.tasklist.backendspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pet.tasklist.backendspringboot.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
