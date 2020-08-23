package tacos.data;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import tacos.Order;
import tacos.Taco;
import tacos.repository.OrderRespository;

@Repository
public class JdbcOrderRepository implements OrderRespository {
	
	private JdbcTemplate jdbc;
	
	private SimpleJdbcInsert orderInserter, orderTacoInserter;
	private ObjectMapper objectMapper;

	public JdbcOrderRepository(JdbcTemplate jdbc) {
		this.orderInserter=new SimpleJdbcInsert(jdbc).withTableName("Taco_Order").usingGeneratedKeyColumns("id");
		this.orderTacoInserter= new SimpleJdbcInsert(jdbc).withTableName("Taco_Order_Tacos");
		this.objectMapper= new ObjectMapper();
	}
	@Override
	public Order save(Order order) {
		// TODO Auto-generated method stub
		order.setPlaceAt(new Date());
		Long orderId=saveOrderDetails(order);
		order.setId(orderId);
		List<Taco> tacos= order.getTacos();
		for(Taco taco:tacos) {
			saveTacoToOrder(taco, orderId);
		}
		return order;
	}
	private void saveTacoToOrder(Taco taco, Long orderId) {
		Map<String, Object> values= new HashMap<>();
		values.put("tacoOrder",orderId);
		values.put("taco",taco);
		orderTacoInserter.execute(values);
		
		// TODO Auto-generated method stub
		
	}
	private Long saveOrderDetails(Order order) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		Map<String, Object> values= objectMapper.convertValue(order, Map.class);
		values.put("placeAt", order.getPlaceAt());
		Long orderId=orderInserter.executeAndReturnKey(values).longValue();
		return orderId;
	}

}
