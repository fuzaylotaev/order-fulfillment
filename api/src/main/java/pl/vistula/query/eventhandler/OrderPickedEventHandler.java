package pl.vistula.query.eventhandler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import pl.vistula.event.OrderCreatedEvent;
import pl.vistula.event.OrderPickedEvent;

@Component
public class OrderPickedEventHandler {

  @EventHandler
  public void on(OrderPickedEvent event) {

  }
}
