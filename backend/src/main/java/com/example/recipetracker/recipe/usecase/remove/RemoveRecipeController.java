package com.example.recipetracker.recipe.usecase.remove;

import com.example.recipetracker.recipe.usecase.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/recipe")
@RequiredArgsConstructor
public class RemoveRecipeController {

    private final RecipeService service;

    @DeleteMapping
    public String deleteRecipe(@RequestParam Long id) {
        return service.deleteRecipe(id);
    }
}
