package pt.com.pascoal.axonexample.event.EventHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.com.pascoal.axonexample.Respository.CustomerViewRepository;
import pt.com.pascoal.axonexample.event.CustomerCreatedEvent;
import pt.com.pascoal.axonexample.mapper.ViewMapper;
import pt.com.pascoal.axonexample.query.model.CustomerView;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerEventHandler {
    @Autowired
    private final CustomerViewRepository viewRepository;
    @Autowired
    private final ViewMapper viewMapper;

    @EventHandler
    public void handleCustomerCreatedEvent(CustomerCreatedEvent event) {
        log.info("Handling event {}", event.toString());
        CustomerView customerView = viewMapper.toCustomerView(event.getCustomer());
        viewRepository.save(customerView);
    }
}
