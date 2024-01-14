package com.example.recipetracker.ingredient.usecase.remove;

import com.example.recipetracker.ingredient.usecase.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ingredient")
@RequiredArgsConstructor
public class RemoveIngredientController {

    private final IngredientService service;

    @DeleteMapping
    public String delete(@RequestParam Long id) {
        return service.delete(id);
    }
}
