package hu.mik.pte.hu.recipe.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.mik.pte.hu.recipe.entity.Recipe;
import hu.mik.pte.hu.recipe.service.RecipeService;
import io.swagger.v3.core.util.Json;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PageController {
    private final RecipeService recipeService;
    private final ObjectMapper objectMapper;

    @GetMapping("recipe_details")
    public String recipeDetails(@RequestParam String id, Model model){

        model.addAttribute("recipe", this.recipeService.findRecipeById(id));
        return "recipe_details";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/delete" )
    public String delete(@RequestBody String jsonRecipe) throws JsonProcessingException {

        Recipe recipe = this.objectMapper.readValue(jsonRecipe, Recipe.class);
        this.recipeService.delete(recipe);
        return "redirect:/all_recipes";
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
