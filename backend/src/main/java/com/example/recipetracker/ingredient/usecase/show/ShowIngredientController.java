package com.example.recipetracker.ingredient.usecase.show;

import com.example.recipetracker.ingredient.usecase.IngredientService;
import com.example.recipetracker.model.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/ingredient")
@RequiredArgsConstructor
public class ShowIngredientController {

    private final IngredientService service;

    @GetMapping
    public List<Ingredient> getIngredientsByName(@RequestParam String name) {
        return service.getIngredientsByName(name);
    }

    @GetMapping("all")
    public List<Ingredient> getAll() {
        return service.getAll();
    }
}
