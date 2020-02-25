package pt.com.pascoal.axonexample.service.impl;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import pt.com.pascoal.axonexample.command.CreateCustomerCommand;
import pt.com.pascoal.axonexample.dto.CustomerDto;
import pt.com.pascoal.axonexample.mapper.CustomerMapper;
import pt.com.pascoal.axonexample.service.CommandService;

@Service
@RequiredArgsConstructor
public class CommandServiceImpl implements CommandService {
    private final CustomerMapper customerMapper;
    private final CommandGateway commandGateway;

    @Override
    public String createCustomer(CustomerDto customerDto) {
        CreateCustomerCommand command = customerMapper.toCreateCustomerCommand(customerDto);
        return commandGateway.sendAndWait(command);
    }
}
