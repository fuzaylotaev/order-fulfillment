package pl.vistula.query.eventhandler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import pl.vistula.event.OrderCreatedEvent;

@Component
public class OrderPackedEventHandler {

  @EventHandler
  public void on(OrderPackedEventHandler event) {

  }
}
