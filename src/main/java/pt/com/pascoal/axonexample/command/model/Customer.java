package pt.com.pascoal.axonexample.command.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import pt.com.pascoal.axonexample.event.CustomerCreatedEvent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
Here the class Customer is the event sourced. It is our aggregate (its just like our @entity : @Aggregate of axon)
* An Aggregate is a regular object, which contains state and methods to alter that state. When creating the Aggregate object, you are effectively creating the 'Aggregate Root', typically carrying the name of the entire Aggregate.
*  @Aggregate annotation tells Axon that this entity will be managed by Axon. Basically, this is similar to the @Entity annotation available with JPA. However, we will be using the Axon recommended annotation.
 @AggregateIdentifier annotation is used for identifying a particular instance of the Aggregate. In other words, this is similar to JPA's @Id annotation.
 */


@Entity
@Data
@Slf4j
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String email;
    private Boolean isActive;
    @AggregateMember
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts;

    public Customer() {
        //required for axon
    }

    public List<Account> getAccounts() {
        if (accounts == null) {
            accounts = new ArrayList<>();
        }
        return accounts;
    }

    public void notifyCustomerCreatedEvent() {
        log.info("applying event for customer created: {}", this.toString());
        AggregateLifecycle.apply(new CustomerCreatedEvent(this));
    }

    @EventSourcingHandler
    void on(CustomerCreatedEvent event) {
        log.info("Event sourcing {}", event.toString());
        id = event.getCustomer().id;
        fullName = event.getCustomer().getFullName();
        email = event.getCustomer().getEmail();
        isActive = event.getCustomer().getIsActive();
    }

}
