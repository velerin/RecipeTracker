package com.example.recipetracker.ingredient.usecase.add;

import java.util.Date;

public record IngredientDto(Long id, String name, Double amount, String unit, Date expireDate, Long recipeId) {
}
