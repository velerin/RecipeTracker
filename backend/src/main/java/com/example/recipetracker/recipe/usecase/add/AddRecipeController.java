package com.example.recipetracker.recipe.usecase.add;

import com.example.recipetracker.model.Recipe;
import com.example.recipetracker.recipe.usecase.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/recipe")
@RequiredArgsConstructor
public class AddRecipeController {

    private final RecipeService service;

    @PostMapping
    public Recipe addRecipe(@RequestBody RecipeDto dto) {
        return service.addRecipe(dto);
    }
}
