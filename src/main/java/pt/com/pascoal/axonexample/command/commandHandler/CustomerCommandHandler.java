package pt.com.pascoal.axonexample.command.commandHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.Aggregate;
import org.axonframework.modelling.command.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.com.pascoal.axonexample.command.CreateCustomerCommand;
import pt.com.pascoal.axonexample.command.model.Customer;
import pt.com.pascoal.axonexample.mapper.CustomerMapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerCommandHandler {

    private final Repository<Customer> customerRepository;
    private final CustomerMapper customerMapper;

    @CommandHandler
    public Long handleCreateCustomerCommand(final CreateCustomerCommand command) throws Exception {
        log.info("Handling command: create customer {}", command);
        Customer customer = customerMapper.toCustomer(command);
        Aggregate<Customer> customerAggregate = customerRepository.newInstance(() -> customer);
        customerAggregate.execute(Customer::notifyCustomerCreatedEvent);
        return (Long) customerAggregate.identifier();
    }
}
