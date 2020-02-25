package pt.com.pascoal.axonexample.config;

import org.springframework.beans.factory.annotation.Qualifier;
import pt.com.pascoal.axonexample.command.model.Account;
import pt.com.pascoal.axonexample.command.model.Customer;
import org.axonframework.common.jpa.SimpleEntityManagerProvider;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.modelling.command.GenericJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class GenericRepositoryConfig {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    @Qualifier(value = "customerRepository")
    public GenericJpaRepository<Customer> customerJpaRepository(EventBus eventBus) {
        SimpleEntityManagerProvider entityManagerProvider = new SimpleEntityManagerProvider(entityManager);
        return GenericJpaRepository.builder(Customer.class)
                .entityManagerProvider(entityManagerProvider)
                .identifierConverter(String::toString)
                .eventBus(eventBus)
                .build();
    }

    @Bean
    @Qualifier(value = "accountRepository")
    public GenericJpaRepository<Account> accountJpaRepository(EventBus eventBus) {
        SimpleEntityManagerProvider entityManagerProvider = new SimpleEntityManagerProvider(entityManager);
        return GenericJpaRepository.builder(Account.class)
                .entityManagerProvider(entityManagerProvider)
                .eventBus(eventBus)
                .build();
    }
}
