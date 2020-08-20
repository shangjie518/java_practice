package tacos.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tacos.Order;
import tacos.repository.OrderRespository;

@Repository
public class JdbcOrderRepository implements OrderRespository {
	
	private JdbcTemplate jdbc;

	public JdbcOrderRepository(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}
	@Override
	public Order save(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
