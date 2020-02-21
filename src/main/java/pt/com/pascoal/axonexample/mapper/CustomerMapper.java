package pt.com.pascoal.axonexample.mapper;

import org.mapstruct.Mapper;
import pt.com.pascoal.axonexample.command.CreateCustomerCommand;
import pt.com.pascoal.axonexample.command.UpdateCustomerCommand;
import pt.com.pascoal.axonexample.command.model.Customer;
import pt.com.pascoal.axonexample.dto.CustomerDto;

@Mapper(componentModel = "Spring")
public interface CustomerMapper {
    Customer toCustomer(CreateCustomerCommand command);
    CreateCustomerCommand toCreateCustomerCommand(CustomerDto customerDto);
    UpdateCustomerCommand toUpdateCustomerCommand(CustomerDto customerDto);
}
