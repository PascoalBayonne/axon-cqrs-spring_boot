package pt.com.pascoal.axonexample.command.commandHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.Aggregate;
import org.axonframework.modelling.command.AggregateNotFoundException;
import org.axonframework.modelling.command.Repository;
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
    public String handleCreateCustomerCommand(final CreateCustomerCommand command) throws Exception {
        log.info("Handling command: create customer {}", command);
        Customer customer = customerMapper.toCustomer(command);
        Aggregate<Customer> aggregate = loadCustomerAggregate(command);
        createOrUpdateCustomer(customer, aggregate);
        return command.getId();
    }


    private Aggregate<Customer> loadCustomerAggregate(final CreateCustomerCommand command) {
        Aggregate<Customer> aggregate = null;
        try {
            aggregate = customerRepository.load(command.getId());
        } catch (AggregateNotFoundException e) {
            log.debug(e.getMessage());
        }
        return aggregate;
    }

    private void createOrUpdateCustomer(Customer customer, Aggregate<Customer> aggregate) throws Exception {
        if (aggregate == null) {
            customerRepository.newInstance(() -> customer)
                    .execute(Customer::notifyCreatedOrUpdatedEvent);
        } else {
            aggregate.execute(s ->customer.notifyCreatedOrUpdatedEvent());
        }
    }
}
