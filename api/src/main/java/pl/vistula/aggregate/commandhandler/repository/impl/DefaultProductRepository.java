package pl.vistula.aggregate.commandhandler.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.vistula.aggregate.commandhandler.repository.ProductRepository;

@Repository
public class DefaultProductRepository implements ProductRepository {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public DefaultProductRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public boolean isProductExistsById(String productId) {
    String sql = "SELECT COUNT(*) FROM command.product WHERE id = ?";
    Integer count = jdbcTemplate.queryForObject(sql, Integer.class, productId);
    return count != null && count > 0;
  }
}
