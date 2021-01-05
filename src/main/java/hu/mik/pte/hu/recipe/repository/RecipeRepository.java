package hu.mik.pte.hu.recipe.repository;

import hu.mik.pte.hu.recipe.entity.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe,String> {
}
