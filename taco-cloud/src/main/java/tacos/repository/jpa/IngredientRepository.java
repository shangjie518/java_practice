package tacos.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import tacos.bean.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
