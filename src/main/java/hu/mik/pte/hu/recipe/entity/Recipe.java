package hu.mik.pte.hu.recipe.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Blob;

@Data
public class Recipe {
    private String id;
    private String name;
    private String description;
    private RecipeTypes type;
    private String image;
}
