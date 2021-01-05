package hu.mik.pte.hu.recipe.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Recipe {
    private String id;
    private String name;
    private String description;
    private RecipeTypes type;
}
