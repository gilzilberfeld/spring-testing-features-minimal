package springtestingfeatures.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ItemRepository {
	
	@Autowired 
	protected JdbcTemplate jdbcTemplate;
	
	public void addItem(Item item) {
		String name = item.getName();
		int value = item.getValue();
		jdbcTemplate.update(
		"INSERT INTO items(name, value) VALUES(?,?)"
		, name, value);
	}

	public Item findByName(String name) {
		Item item = jdbcTemplate.queryForObject(
				"select * from items where name=?", 
				new Object[] {name},
				new BeanPropertyRowMapper<Item>(Item.class)
				);
		return item;

	}
	
	public List<Item> getAllItems() {
		return jdbcTemplate.queryForList(
				"select * from items", Item.class);
	}
}
