package pt.com.pascoal.axonexample.event;

import lombok.Value;
import pt.com.pascoal.axonexample.command.model.Customer;


@Value
public class CustomerCreatedEvent {
    private Customer customer;

}
