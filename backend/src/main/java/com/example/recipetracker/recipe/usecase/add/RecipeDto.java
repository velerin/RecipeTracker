package com.example.recipetracker.recipe.usecase.add;


import com.example.recipetracker.ingredient.usecase.add.IngredientDto;

import java.util.List;

public record RecipeDto(String name, String description, String cookingRecipe, List<IngredientDto> ingredients) {
}
