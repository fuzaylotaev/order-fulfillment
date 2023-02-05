package pl.vistula.event;

import java.util.Objects;

public class OrderPickedEvent {

  private final String orderId;

  public OrderPickedEvent(String orderId) {
    this.orderId = orderId;
  }

  public String getOrderId() {
    return orderId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderPickedEvent that = (OrderPickedEvent) o;
    return Objects.equals(orderId, that.orderId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId);
  }

  @Override
  public String toString() {
    return "OrderPickedEvent{" +
        "orderId='" + orderId + '\'' +
        '}';
  }
}
