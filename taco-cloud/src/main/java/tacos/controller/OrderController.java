package tacos.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;
import tacos.bean.Order;
import tacos.repository.OrderRespository;

@Controller
@RequestMapping("/orders")
@Slf4j
public class OrderController {
	
	private OrderRespository orderRespo;

	public OrderController(OrderRespository orderRespo) {
		this.orderRespo=orderRespo;
	}
	
	@GetMapping("/current")
	public String orderForm(Model model) {
		//model.addAttribute("order", new Order());
		log.info("/orders/current");
		return "orderForm";
	}
	
	
	@PostMapping
	public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus) {
		if(errors.hasErrors()) {
			log.error(errors.toString());
			return "orderForm";
		}
		orderRespo.save(order);
		sessionStatus.setComplete();
		return "redirect:/";
	}
}
