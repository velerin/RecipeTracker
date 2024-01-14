package com.example.recipetracker.recipe.usecase;

import com.example.recipetracker.exception.EntityNotFundException;
import com.example.recipetracker.ingredient.usecase.IngredientService;
import com.example.recipetracker.model.Ingredient;
import com.example.recipetracker.model.Recipe;
import com.example.recipetracker.recipe.repository.RecipeRepository;
import com.example.recipetracker.recipe.usecase.add.RecipeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {


    private final RecipeRepository recipeRepository;
    private final IngredientService ingredientService;

    @Override
    public Recipe addRecipe(RecipeDto dto) {
        var recipe = new Recipe();
        recipe.setName(dto.name());
        recipe.setDescription(dto.description());
        recipe.setCookingRecipe(dto.cookingRecipe());
        recipe.setIngredients(dto.ingredients().stream().map(ingredient ->
                        new Ingredient(
                                ingredient.name(),
                                ingredient.amount(),
                                ingredient.unit(),
                                ingredient.expireDate(),
                                recipe))
                .toList());
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        var retrievedRecipe = recipeRepository.findById(recipe.getId());
        if (retrievedRecipe.isEmpty()) {
            throw new EntityNotFundException("Recipe not found");
        }
        var updatedRecipe = retrievedRecipe.get();
        updatedRecipe.setName(recipe.getName());
        updatedRecipe.setCookingRecipe(recipe.getCookingRecipe());
        updatedRecipe.setDescription(recipe.getDescription());
        updatedRecipe.setIngredients(recipe.getIngredients().stream().map(ingredientService::update).toList());

        return recipeRepository.save(updatedRecipe);
    }

    @Override
    public String deleteRecipe(Long id) {
        if (!recipeRepository.existsById(id)) {
            throw new EntityNotFundException("Recipe not found");
        }

        recipeRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Recipe showRecipe(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new EntityNotFundException("Recipe not found with id: " + id));
    }

    @Override
    public List<Recipe> showAllRecipes() {
        return recipeRepository.findAll();
    }
}
