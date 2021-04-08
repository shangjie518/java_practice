package tacos.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import tacos.bean.Order;

public interface OrderRespository extends CrudRepository<Order, Long> {

}
