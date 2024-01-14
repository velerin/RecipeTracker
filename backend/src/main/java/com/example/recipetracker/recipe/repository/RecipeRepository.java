package com.example.recipetracker.recipe.repository;

import com.example.recipetracker.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
