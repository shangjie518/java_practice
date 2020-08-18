package tacos.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import tacos.repository.IngredientRepository;

public class JdbcIngredientReposity implements IngredientRepository {

	
	
	private JdbcTemplate jdbc;
	
	public JdbcIngredientReposity(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}
	
	@Override
	public Iterable<Ingredient> findAll() {
		// TODO Auto-generated method stub

		return jdbc.query("select id, name, type from Ingredient", new RowMapper<Ingredient>() {

			@Override
			public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new Ingredient(rs.getString("id"), rs.getString("name"), 
						Ingredient.Type.valueOf(rs.getString("type")));
			}});
	}

	@Override
	public Ingredient findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return null;
	}

}
