package com.example.recipetracker.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double amount;
    private String unit;
    private Date expireDate;
    private Double boughtAmount;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;


    public Ingredient(String name, Double amount, String unit, Date expireDate, Recipe recipe) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.expireDate = expireDate;
        this.boughtAmount = 0.0;
        this.recipe = recipe;
    }
}
