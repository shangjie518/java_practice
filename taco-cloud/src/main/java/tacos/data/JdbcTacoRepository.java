package tacos.data;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import tacos.Ingredient;
import tacos.Taco;
import tacos.repository.TacoRepository;

@Repository
public class JdbcTacoRepository implements TacoRepository {

	private JdbcTemplate jdbc;

	public JdbcTacoRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Taco save(Taco taco) {
		// TODO Auto-generated method stub
		Long tacoId = saveTacoInfo(taco);
		taco.setId(tacoId);

		for(Ingredient ingre:taco.getIngredients()) {
			saveIngredientToTaco(ingre, tacoId);
		}
		return taco;
	}

	private void saveIngredientToTaco(Ingredient ingre, Long tacoId) {
		// TODO Auto-generated method stub
		jdbc.update("insert into Taco_Ingredients (taco, ingredient) values (?,?)",
				tacoId, ingre.getId());
		
		
	}

	private Long saveTacoInfo(Taco taco) {
		// TODO Auto-generated method stub
		
		taco.setCreateAt(new Date());
		PreparedStatementCreator psc = new PreparedStatementCreatorFactory(
				"insert into Taco(name, createdAt) values(?, ?)", Types.VARCHAR, Types.DATE)
				.newPreparedStatementCreator(Arrays.asList(taco.getName(),new Timestamp(taco.getCreateAt().getTime())));
		
		KeyHolder keyholder= new GeneratedKeyHolder();
		jdbc.update(psc, keyholder);
		return keyholder.getKey().longValue();
	}

}
