package Domain;

import Base.Entity.BasePerson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import utils.Time;
import utils.UID;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer extends BasePerson {
    //C registeringBranch
    //A customerNumber
    //C bankAccount
    // joinDate
    public static final String COLUMN_CUSTOMER_NUMBER_NAME = "customer_number";
    public static final String COLUMN_JOIN_DATE_NAME = "join_date";


    @PrePersist
    private void setUniqueCustomerNumber() throws Exception {
        setJoinDate(new Time().now());
        setCustomerNumber(new UID().getNew());
        if(bankAccounts.size()==0) throw new Exception("user has no bank account");

    }


    public Customer(String firstName, String lastName, Long nationalCode, Branch registeringBranch) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.registeringBranch = registeringBranch;
        bankAccounts.add(new BankAccount(this));
    }


    @ManyToOne(optional = false)
    @JoinColumn(name = "registering_branch_id", nullable = false, updatable = false)
    private Branch registeringBranch;

    @Column(name = COLUMN_CUSTOMER_NUMBER_NAME, nullable = false, unique = true, updatable = false)
    private Long customerNumber;

    @OneToMany(mappedBy = "owner", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private Set<BankAccount> bankAccounts = new HashSet<>();

    @Column(name = COLUMN_JOIN_DATE_NAME, nullable = false, updatable = false)
    private Timestamp joinDate;


    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "firstName = " + getFirstName() + ", " +
                "lastName = " + getLastName() + ", " +
                "nationalCode = " + getNationalCode() + ", " +
                "registeringBranch = " + getRegisteringBranch() + ", " +
                "customerNumber = " + getCustomerNumber() + ", " +
                "joinDate = " + getJoinDate() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}