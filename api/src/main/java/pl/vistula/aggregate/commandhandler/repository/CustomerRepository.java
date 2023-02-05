package pl.vistula.aggregate.commandhandler.repository;

public interface CustomerRepository {

  boolean isCustomerExistsById(String customerId);
}
