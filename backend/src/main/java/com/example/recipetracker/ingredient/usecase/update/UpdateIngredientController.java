package com.example.recipetracker.ingredient.usecase.update;

import com.example.recipetracker.ingredient.usecase.IngredientService;
import com.example.recipetracker.model.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ingredient")
@RequiredArgsConstructor
public class UpdateIngredientController {

    private final IngredientService service;

    @PutMapping
    public Ingredient update(@RequestBody Ingredient ingredient) {
        return service.update(ingredient);
    }
}
