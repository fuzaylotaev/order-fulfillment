package pl.vistula.aggregate.commandhandler.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.vistula.aggregate.commandhandler.repository.CustomerRepository;

import javax.sql.DataSource;

@Repository
public class DefaultCustomerRepository implements CustomerRepository {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public DefaultCustomerRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public boolean isCustomerExistsById(String customerId) {
    String sql = "SELECT COUNT(*) FROM command.customer WHERE id = ?";
    Integer count = jdbcTemplate.queryForObject(sql, Integer.class, customerId);
    return count != null && count > 0;
  }
}
