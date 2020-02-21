package pt.com.pascoal.axonexample.command.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pt.com.pascoal.axonexample.dto.CustomerDto;
import pt.com.pascoal.axonexample.service.CommandService;
import pt.com.pascoal.axonexample.utils.CustomHttpUtil;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CommandService commandService;

    @PostMapping(value = "/customer")
    public ResponseEntity<Void> create(@RequestBody CustomerDto customerDto) {
        Long id = commandService.createCustomer(customerDto);
        HttpHeaders resourceHeaderLocation = CustomHttpUtil.getResponseHeader(id);
        return ResponseEntity.ok().headers(resourceHeaderLocation).build();
    }

}
