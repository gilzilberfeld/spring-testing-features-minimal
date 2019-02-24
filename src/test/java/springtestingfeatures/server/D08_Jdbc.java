package springtestingfeatures.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import springtestingfeatures.server.configurations.D08_JdbcConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes= {D08_JdbcConfiguration.class})
@Sql(scripts = "classpath:CreateItemsSchema.sql", 
	executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:DeleteItemsSchema.sql", 
	executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class D08_Jdbc{
	
	@Autowired ItemRepository itemRepository;
	@Autowired JdbcTemplate jdbcTemplate;


	@Test
	public void itemIsAddedByController_UsingJdbcTemplateToQuery() {
		Item item = new Item("Item1", 2);

		itemRepository.addItem(item);
	
		Item addedItem = jdbcTemplate.queryForObject(
				"select * from items where name=?", 
				new Object[] {"Item1"},
				new BeanPropertyRowMapper<Item>(Item.class)
				);
		
		assertEquals(2, addedItem.getValue());
	}

}
