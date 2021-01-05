package hu.mik.pte.hu.recipe.controller;

import hu.mik.pte.hu.recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PageController {
    private final RecipeService recipeService;

    @GetMapping("recipe_details")
    public String recipeDetails(@RequestParam(defaultValue = "TESZT") String id, Model model){

        model.addAttribute("recipe", this.recipeService.findRecipeById(id));
        return "recipe_details";
    }

    @GetMapping()
    public String greeting(){
        return "greeting";
    }

    @GetMapping("/new_recipe")
    public String newRecipe(){
        return "new_recipe";
    }

    @GetMapping("/all_recipes")
    public String allRecipes(){
        return "all_recipes";
    }
}
