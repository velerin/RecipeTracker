package com.example.recipetracker.ingredient.usecase;

import com.example.recipetracker.exception.EntityNotFundException;
import com.example.recipetracker.ingredient.repository.IngredientRepository;
import com.example.recipetracker.ingredient.usecase.add.IngredientDto;
import com.example.recipetracker.model.Ingredient;
import com.example.recipetracker.recipe.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;

    @Override
    public Ingredient add(IngredientDto dto) {
        var ingredient = new Ingredient(
                dto.name(),
                dto.amount(),
                dto.unit(),
                dto.expireDate(),
                recipeRepository.findById(dto.recipeId())
                        .orElseThrow(() -> new EntityNotFundException("Recipe not found!!!"))
        );
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        var retrieved = ingredientRepository.findById(ingredient.getId());
        if (retrieved.isEmpty()) {
            throw new EntityNotFundException("Recipe not found");
        }
        var updated = retrieved.get();
        updated.setName(ingredient.getName());
        updated.setUnit(ingredient.getUnit());
        updated.setAmount(ingredient.getAmount());
        updated.setExpireDate(ingredient.getExpireDate());
        updated.setRecipe(ingredient.getRecipe());

        return ingredientRepository.save(updated);
    }

    @Override
    public String delete(Long id) {
        if (!ingredientRepository.existsById(id)) {
            throw new EntityNotFundException("Ingredient not found");
        }
        ingredientRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public List<Ingredient> getIngredientsByName(String name) {
        return ingredientRepository.findAllByName(name);
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }
}
