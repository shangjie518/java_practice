package tacos.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import tacos.bean.Taco;

public interface TacoRespository extends CrudRepository<Taco, Long> {

}
