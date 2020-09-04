package tacos.repository.jdbc;

import tacos.bean.Order;

public interface OrderRespository {

	Order save(Order order);
}
