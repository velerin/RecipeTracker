package com.example.recipetracker.ingredient.repository;

import com.example.recipetracker.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllByName(String name);
}
