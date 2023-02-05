package pl.vistula.aggregate.commandhandler.repository;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import pl.vistula.command.CreateOrderCommand;

import java.util.Objects;

public class ValidateAndCreateOrderCommand {

  @TargetAggregateIdentifier
  private final String orderId;
  private final String productId;
  private final String customerId;

  public ValidateAndCreateOrderCommand(String orderId, String productId, String customerId) {
    this.orderId = orderId;
    this.productId = productId;
    this.customerId = customerId;
  }

  public String getOrderId() {
    return orderId;
  }

  public String getProductId() {
    return productId;
  }

  public String getCustomerId() {
    return customerId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidateAndCreateOrderCommand that = (ValidateAndCreateOrderCommand) o;
    return Objects.equals(orderId, that.orderId)
        && Objects.equals(productId, that.productId)
        && Objects.equals(customerId, that.customerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, productId, customerId);
  }

  @Override
  public String toString() {
    return "ValidateAndCreateOrderCommand{" +
        "orderId='" + orderId + '\'' +
        ", productId='" + productId + '\'' +
        ", customerId='" + customerId + '\'' +
        '}';
  }
}
