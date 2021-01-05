package hu.mik.pte.hu.recipe.restcontroller;

import hu.mik.pte.hu.recipe.entity.Recipe;
import hu.mik.pte.hu.recipe.entity.RecipeTypes;
import hu.mik.pte.hu.recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/all_recipes")
        public List<Recipe> getAllRecipes(){ return this.recipeService.findAllRecipes(); }

    @GetMapping("/types")
    public RecipeTypes[] getTypes(){ return this.recipeService.getTypes(); }

    @PutMapping("/save")
    public Recipe save(@RequestBody Recipe recipe){return this.recipeService.save(recipe); };
}
