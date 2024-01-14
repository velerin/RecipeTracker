package com.example.recipetracker.recipe.usecase;

import com.example.recipetracker.model.Recipe;
import com.example.recipetracker.recipe.usecase.add.RecipeDto;

import java.util.List;

public interface RecipeService {
    Recipe addRecipe(RecipeDto dto);

    Recipe updateRecipe(Recipe recipe);

    String deleteRecipe(Long id);

    Recipe showRecipe(Long id);

    List<Recipe> showAllRecipes();

}
