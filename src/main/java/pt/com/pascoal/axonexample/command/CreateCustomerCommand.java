package pt.com.pascoal.axonexample.command;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/*
 * However, the most important thing to note here is the @TargetAggregateIdentifier annotation.
 * Basically, this is an Axon specific requirement to identify the aggregate instance.
 * In other words, this annotation is required for Axon to determine the instance of the Aggregate that should handle the command. The annotation can be placed on either the field or the getter method. In this example, we chose to put it on the field.
 * */

@Data
@NoArgsConstructor
public class CreateCustomerCommand {
    @TargetAggregateIdentifier
    private String id;
    private String fullName;
    private String email;
    private Boolean isActive;

}
