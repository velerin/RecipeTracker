package com.example.recipetracker.ingredient.usecase.add;

import com.example.recipetracker.ingredient.usecase.IngredientService;
import com.example.recipetracker.model.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ingredient")
@RequiredArgsConstructor
public class AddIngredientController {

    private final IngredientService service;

    @PostMapping
    public Ingredient add(@RequestBody IngredientDto dto) {
        return service.add(dto);
    }
}
