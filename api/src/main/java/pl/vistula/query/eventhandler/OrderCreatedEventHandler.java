package pl.vistula.query.eventhandler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pl.vistula.core.OrderStatus;
import pl.vistula.event.OrderCreatedEvent;

@Component
public class OrderCreatedEventHandler {

  private final JdbcTemplate jdbcTemplate;

  public OrderCreatedEventHandler(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @EventHandler
  public void on(OrderCreatedEvent event) {
    String sql = "INSERT INTO query.order (order_id, customer_id, product_id, status) VALUES (?, ?, ?, ?)";
    jdbcTemplate.update(sql, event.getOrderId(), event.getCustomerId(), event.getProductId(), OrderStatus.CREATED.toString());
  }
}
