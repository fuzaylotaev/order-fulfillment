package pl.vistula.query.eventhandler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import pl.vistula.event.OrderConfirmedEvent;
import pl.vistula.event.OrderCreatedEvent;

@Component
public class OrderConfirmedEventHandler {

  @EventHandler
  public void on(OrderConfirmedEvent event) {

  }
}
