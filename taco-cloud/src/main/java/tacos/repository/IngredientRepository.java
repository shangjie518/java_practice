package tacos.repository;

import tacos.Ingredient;

public interface IngredientRepository {

	Iterable<Ingredient> findAll();
	Ingredient findOne(String id);
	Ingredient findById(String id);
	Ingredient save (Ingredient ingredient);
}
