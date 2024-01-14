package com.example.recipetracker.recipe.usecase.show;

import com.example.recipetracker.model.Recipe;
import com.example.recipetracker.recipe.usecase.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/recipe")
@RequiredArgsConstructor
public class ShowRecipeController {

    private final RecipeService service;

    @GetMapping
    public Recipe showRecipe(@RequestParam Long id) {
        return service.showRecipe(id);
    }

    @GetMapping("all")
    public List<Recipe> showAllRecipes() {
        return service.showAllRecipes();
    }

}
