package pl.vistula.query.eventhandler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class OrderShippedEventHandler {

  @EventHandler
  public void on(OrderPackedEventHandler event) {

  }
}
