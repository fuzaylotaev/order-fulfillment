package pl.vistula.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class PickOrderCommand {

  @TargetAggregateIdentifier
  private final String orderId;

  public PickOrderCommand(String orderId) {
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
    PickOrderCommand that = (PickOrderCommand) o;
    return Objects.equals(orderId, that.orderId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId);
  }

  @Override
  public String toString() {
    return "PickOrderCommand{" +
        "orderId='" + orderId + '\'' +
        '}';
  }
}
