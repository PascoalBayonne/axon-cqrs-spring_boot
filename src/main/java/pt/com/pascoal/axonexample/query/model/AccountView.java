package pt.com.pascoal.axonexample.query.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class AccountView {
    @Id
    private Long id;
    private Double balance;
    private String status;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CustomerView customerView;

}
