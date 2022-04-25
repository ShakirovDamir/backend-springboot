package ru.pet.tasklist.backendspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pet.tasklist.backendspringboot.entity.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByOrderByTitleAsc();
}
