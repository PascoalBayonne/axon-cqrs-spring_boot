package pt.com.pascoal.axonexample.mapper;

import org.mapstruct.Mapper;
import pt.com.pascoal.axonexample.command.model.Customer;
import pt.com.pascoal.axonexample.query.model.CustomerView;

@Mapper(componentModel = "Spring")
public interface ViewMapper {

    CustomerView toCustomerView(Customer customer);
}
