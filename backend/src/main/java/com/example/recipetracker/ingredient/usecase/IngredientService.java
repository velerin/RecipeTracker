package com.example.recipetracker.ingredient.usecase;

import com.example.recipetracker.ingredient.usecase.add.IngredientDto;
import com.example.recipetracker.model.Ingredient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IngredientService {

    Ingredient add(@RequestBody IngredientDto dto);

    Ingredient update(@RequestBody Ingredient ingredient);

    String delete(@RequestParam Long id);

    List<Ingredient> getIngredientsByName(String name);

    List<Ingredient> getAll();
}
