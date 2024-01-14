package com.example.recipetracker.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String cookingRecipe;
    private String type;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Ingredient> ingredients;

    public Recipe(String name, String description, String cookingRecipe, List<Ingredient> ingredients) {
        this.name = name;
        this.description = description;
        this.cookingRecipe = cookingRecipe;
        this.ingredients = ingredients;
    }
}
