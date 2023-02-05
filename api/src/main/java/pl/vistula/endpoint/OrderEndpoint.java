package pl.vistula.endpoint;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.vistula.aggregate.commandhandler.repository.ValidateAndCreateOrderCommand;
import pl.vistula.query.GetOrdersQuery;
import pl.vistula.query.Order;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
public class OrderEndpoint {

  private final CommandGateway commandGateway;
  private final QueryGateway queryGateway;

  @Autowired
  public OrderEndpoint(CommandGateway commandGateway, QueryGateway queryGateway) {
    this.commandGateway = commandGateway;
    this.queryGateway = queryGateway;
  }

  @PostMapping("/orders/create")
  public CompletableFuture<Void> createOrder() {
    String orderId = UUID.randomUUID().toString();
    System.out.println("==================Linux==================");
    return commandGateway.send(new ValidateAndCreateOrderCommand(orderId, "product-1", "test1@gmail.com"));
  }

  @GetMapping("/orders")
  public CompletableFuture<List<Order>> findAllOrders() {
    return queryGateway.query(new GetOrdersQuery(), ResponseTypes.multipleInstancesOf(Order.class));
  }

  @GetMapping("/**")
  public String helloWorld() {
    long sum = 0;
    for (long i = 0; i < 1000000000L; i++) {
      sum += i;
    }
    return "Linux";
  }
}
