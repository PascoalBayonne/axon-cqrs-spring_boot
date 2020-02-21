package pt.com.pascoal.axonexample.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/*
 * However, the most important thing to note here is the @TargetAggregateIdentifier annotation.
 * Basically, this is an Axon specific requirement to identify the aggregate instance.
 * In other words, this annotation is required for Axon to determine the instance of the Aggregate that should handle the command. The annotation can be placed on either the field or the getter method. In this example, we chose to put it on the field.
 * */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerCommand {
    private Long id;
    private String fullName;
    private String email;
    private Boolean isActive;

    @TargetAggregateIdentifier
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
