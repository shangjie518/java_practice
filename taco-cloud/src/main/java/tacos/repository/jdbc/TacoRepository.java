package tacos.repository.jdbc;

import tacos.bean.Taco;

public interface TacoRepository {

	Taco save(Taco design);
}
