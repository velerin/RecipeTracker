package com.example.recipetracker.recipe.usecase.update;

import com.example.recipetracker.model.Recipe;
import com.example.recipetracker.recipe.usecase.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/recipe")
@RequiredArgsConstructor
public class UpdateRecipeController {

    private final RecipeService service;

    @PutMapping
    public Recipe updateRecipe(@RequestBody Recipe recipe) {
        return service.updateRecipe(recipe);
    }
}
