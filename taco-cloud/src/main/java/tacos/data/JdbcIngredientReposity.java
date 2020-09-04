package tacos.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tacos.bean.Ingredient;
import tacos.repository.jdbc.IngredientRepository;
@Repository
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
		return jdbc.queryForObject("select id,name,type from Ingredient where id= ?", new RowMapper<Ingredient>() {

			@Override
			public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new Ingredient(rs.getString("id"), rs.getString("name"), 
						Ingredient.Type.valueOf(rs.getString("type")));
			}}, id);
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		// TODO Auto-generated method stub
		jdbc.update("insert into Ingredient values (?, ?, ?)", ingredient.getId(), ingredient.getName(), ingredient.getType().toString());
		return ingredient;
	}

	@Override
	public Ingredient findById(String id) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject("select id,name,type from Ingredient where id= ?", new RowMapper<Ingredient>() {

			@Override
			public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new Ingredient(rs.getString("id"), rs.getString("name"), 
						Ingredient.Type.valueOf(rs.getString("type")));
			}}, id);
	}

}
