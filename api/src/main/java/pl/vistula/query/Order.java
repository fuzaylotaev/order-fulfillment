package pl.vistula.query;

import pl.vistula.core.OrderStatus;

import java.util.Objects;

public class Order {

  private final String orderId;
  private final String productId;
  private final String customerId;
  private final OrderStatus orderStatus;

  public Order(String orderId, String productId, String customerId, OrderStatus orderStatus) {
    this.orderId = orderId;
    this.productId = productId;
    this.customerId = customerId;
    this.orderStatus = orderStatus;
  }

  public String getOrderId() {
    return orderId;
  }

  public String getProductId() {
    return productId;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public String getCustomerId() {
    return customerId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return Objects.equals(orderId, order.orderId) && Objects.equals(productId, order.productId) && orderStatus == order.orderStatus;
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, productId, orderStatus);
  }

  @Override
  public String toString() {
    return "Order{" +
        "orderId='" + orderId + '\'' +
        ", productId='" + productId + '\'' +
        ", orderStatus=" + orderStatus +
        '}';
  }
}
