package Domain;

import Base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class Customer {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
//    @Id
    @Column(name = "customer_number", unique = true)
    @GeneratedValue(
            strategy =GenerationType.TABLE ,
            generator = "customer_uid_seq")
    @SequenceGenerator(
            name = "customer_uid_seq",
            sequenceName = "customer_uid_gen"
            , allocationSize = 452_386
            ,initialValue = 1_001_507_092
    )
        private Long customerNumber;



}