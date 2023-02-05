package pl.vistula.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import pl.vistula.command.*;
import pl.vistula.core.OrderStatus;
import pl.vistula.event.*;
import pl.vistula.exception.OrderException;

@Aggregate
public class OrderAggregate {

  @AggregateIdentifier
  private String orderId;
  private OrderStatus orderStatus;

  @CommandHandler
  public OrderAggregate(CreateOrderCommand command) {
    AggregateLifecycle.apply(new OrderCreatedEvent(
        command.getOrderId(),
        command.getProductId(),
        command.getCustomerId()
    ));
  }

  @CommandHandler
  public void handle(ConfirmOrderCommand command) {
    if (OrderStatus.CREATED != orderStatus) {
      throw new OrderException(String.format(
          "To confirm order %s, its status should be %s",
          orderId,
          OrderStatus.CREATED
      ));
    }
    AggregateLifecycle.apply(new OrderConfirmedEvent(orderId));
  }

  @CommandHandler
  public void handle(PickOrderCommand command) {
    if (OrderStatus.CONFIRMED != orderStatus) {
      throw new OrderException(String.format(
          "To pick order %s, its status should be %s",
          orderId,
          OrderStatus.CONFIRMED
      ));
    }
    AggregateLifecycle.apply(new OrderPickedEvent(orderId));
  }

  @CommandHandler
  public void handle(PackOrderCommand command) {
    if (OrderStatus.PICKED != orderStatus) {
      throw new OrderException(String.format(
          "To pack order %s, its status should be %s",
          orderId,
          OrderStatus.PICKED
      ));
    }
    AggregateLifecycle.apply(new OrderPackedEvent(orderId));
  }

  @CommandHandler
  public void handle(ShipOrderCommand command) {
    if (OrderStatus.PICKED != orderStatus) {
      throw new OrderException(String.format(
          "To ship order %s, its status should be %s",
          orderId,
          OrderStatus.PACKED
      ));
    }
    AggregateLifecycle.apply(new OrderShippedEvent(orderId));
  }

  @EventSourcingHandler
  public void on(OrderCreatedEvent event) {
    this.orderId = event.getOrderId();
    this.orderStatus = OrderStatus.CREATED;
  }

  @EventSourcingHandler
  public void on(OrderConfirmedEvent event) {
    this.orderStatus = OrderStatus.CONFIRMED;
  }

  @EventSourcingHandler
  public void on(OrderPickedEvent event) {
    this.orderStatus = OrderStatus.PICKED;
  }

  @EventSourcingHandler
  public void on(OrderPackedEvent event) {
    this.orderStatus = OrderStatus.PACKED;
  }

  @EventSourcingHandler
  public void on(OrderShippedEvent event) {
    this.orderStatus = OrderStatus.SHIPPED;
  }

  protected OrderAggregate() {

  }
}
