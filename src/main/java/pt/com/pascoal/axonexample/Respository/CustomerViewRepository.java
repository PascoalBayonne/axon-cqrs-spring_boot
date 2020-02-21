package pt.com.pascoal.axonexample.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.com.pascoal.axonexample.query.model.CustomerView;

@Repository
public interface CustomerViewRepository extends JpaRepository<CustomerView, String> {
}
