package pt.com.pascoal.axonexample.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerCommand {
    @TargetAggregateIdentifier
    private String id;
    private String fullName;
    private String email;
    private Boolean isActive;
}
