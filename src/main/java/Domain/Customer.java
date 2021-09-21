package Domain;

import Base.BaseEntity;
import Base.BasePerson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import utils.Time;
import utils.UID;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer extends BasePerson {

    public static final String COLUMN_CUSTOMER_NUMBER_NAME = "customer_number";
    public static final String COLUMN_JOIN_DATE_NAME = "join_date";

    @ManyToOne(optional = false)
    @JoinColumn(name = "registering_branch_id", nullable = false, updatable = false)
    private Branch registeringBranch;

    @PrePersist
    private void setUniqueCustomerNumber(){
        setJoinDate(new Time().now());
        setCustomerNumber(new UID().getNew());
    }


    @Immutable
    @Column(name = COLUMN_CUSTOMER_NUMBER_NAME, nullable = false, unique = true,updatable = false)
    private Long customerNumber;

    @OneToMany(mappedBy = "owner", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private List<BankAccount> bankAccount;

    @Immutable
    @Column(name = COLUMN_JOIN_DATE_NAME, nullable = false, updatable = false)
    private Timestamp joinDate;



}