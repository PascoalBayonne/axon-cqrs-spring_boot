package pt.com.pascoal.axonexample.service;

import pt.com.pascoal.axonexample.dto.CustomerDto;

public interface CommandService {
    Long createCustomer(CustomerDto customerDto);
}
