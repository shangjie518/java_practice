package tacos.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.bean.Ingredient;
import tacos.bean.Order;
import tacos.bean.Taco;
import tacos.bean.Ingredient.Type;
import tacos.repository.IngredientRepository;
import tacos.repository.TacoRepository;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController{
	
	private final IngredientRepository ingredientRepository;
	private  TacoRepository tacoRepository;
	@Autowired
	public DesignTacoController(IngredientRepository ingredientRepository, TacoRepository tacoRepository) {
		this.ingredientRepository=ingredientRepository;
		this.tacoRepository=tacoRepository;
	}
	
	private List<Ingredient>filterByType (List <Ingredient> ingredients, Type type ){
		
		
		return ingredients.stream().filter(x->x.getType().equals(type)).collect(Collectors.toList());
		
	}

	@GetMapping
	public String showDesignForm(Model model) {
	
		
		List<Ingredient> ingredients= new ArrayList<>();
		this.ingredientRepository.findAll().forEach(i->ingredients.add(i));
		
		Type[] types = Ingredient.Type.values();
		for(Type type:types ) {
			model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients, type));
			
		}
		
		Iterator iter=model.asMap().entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry entry=(Map.Entry)iter.next();
			log.info("Key="+entry.getKey().toString()+" Value="+entry.getValue().toString());
		}

		return "design";
		
		
		
	}
	
	@PostMapping
	public String processDesign(@Valid Taco design, Errors errors, Order order) {
		if (errors.hasErrors()) {
			log.error(errors.toString());
			return "design";
		}
		
		Taco saved= tacoRepository.save(design);
		order.addDesign(saved);
		log.info("order added successfully and redirect to /orders/current");
		return "redirect:/orders/current";
	}
	
	@ModelAttribute(name="order")
	public Order order() {
		return new Order();
	}
	@ModelAttribute(name= "taco")
	public Taco taco() {
		return new Taco();
	}
	
}
