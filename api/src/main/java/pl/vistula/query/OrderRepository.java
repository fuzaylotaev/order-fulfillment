package pl.vistula.query;

import org.aspectj.weaver.ast.Or;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.vistula.core.OrderStatus;

import java.util.List;

@Repository
public class OrderRepository {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public OrderRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @QueryHandler
  public List<Order> getOrders(GetOrdersQuery query) {
    List<Order> orders = jdbcTemplate.query("SELECT * FROM query.order",
        (rs, rowNum) ->
        new Order(
            rs.getString("order_id"),
            rs.getString("product_id"),
            rs.getString("customer_id"),
            OrderStatus.valueOf(rs.getString("status"))
        ));
    return orders;
  }
}
