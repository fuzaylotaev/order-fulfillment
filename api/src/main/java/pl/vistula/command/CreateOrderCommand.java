package pl.vistula.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class CreateOrderCommand {

  @TargetAggregateIdentifier
  private final String orderId;
  private final String productId;
  private final String customerId;

  public CreateOrderCommand(String orderId, String productId, String customerId) {
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
    CreateOrderCommand that = (CreateOrderCommand) o;
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
    return "CreateOrderCommand{" +
        "orderId='" + orderId + '\'' +
        ", productId='" + productId + '\'' +
        ", customerId='" + customerId + '\'' +
        '}';
  }
}
