package pl.vistula.aggregate.commandhandler.repository;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.vistula.command.CreateOrderCommand;
import pl.vistula.exception.CustomerException;
import pl.vistula.exception.ProductException;

@Component
public class ValidateAndCreateOrderCommandHandler {

  private final CommandGateway commandGateway;
  private final CustomerRepository customerRepository;
  private final ProductRepository productRepository;

  @Autowired
  public ValidateAndCreateOrderCommandHandler(
      CommandGateway commandGateway,
      CustomerRepository customerRepository,
      ProductRepository productRepository) {
    this.commandGateway = commandGateway;
    this.customerRepository = customerRepository;
    this.productRepository = productRepository;
  }

  @CommandHandler
  public void handle(ValidateAndCreateOrderCommand command) {
    String customerId = command.getCustomerId();
    if (!customerRepository.isCustomerExistsById(customerId)) {
      throw new CustomerException(String.format("No customer found with id: %s", customerId));
    }
    String productId = command.getProductId();
    if (!productRepository.isProductExistsById(productId)) {
      throw new ProductException(String.format("No product found with id: %s", productId));
    }
    commandGateway.send(new CreateOrderCommand(command.getOrderId(), productId, customerId));
  }
}
