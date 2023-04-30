package com.simplilearn.sporty.shoes.repository;

import com.simplilearn.sporty.shoes.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    boolean existsByCategoryName(String name);
}
