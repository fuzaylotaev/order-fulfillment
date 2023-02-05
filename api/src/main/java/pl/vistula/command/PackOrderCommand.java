package pl.vistula.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class PackOrderCommand {

  @TargetAggregateIdentifier
  private final String orderId;

  public PackOrderCommand(String orderId) {
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
    PackOrderCommand that = (PackOrderCommand) o;
    return Objects.equals(orderId, that.orderId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId);
  }

  @Override
  public String toString() {
    return "PackOrderCommand{" +
        "orderId='" + orderId + '\'' +
        '}';
  }
}
