package hu.mik.pte.hu.recipe.service;

import hu.mik.pte.hu.recipe.entity.Recipe;
import hu.mik.pte.hu.recipe.entity.RecipeTypes;
import hu.mik.pte.hu.recipe.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public Recipe save(Recipe recipe){
        return this.recipeRepository.save(recipe);
    }

    public Optional<Recipe> findRecipeById(String id){return this.recipeRepository.findById(id);}

    public List<Recipe> findAllRecipes(){ return this.recipeRepository.findAll(); }

    public RecipeTypes[] getTypes() { return RecipeTypes.values(); }

    public void delete(Recipe recipe) { this.recipeRepository.delete(recipe); }
}
