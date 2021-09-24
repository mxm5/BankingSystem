package Domain;

import Base.Entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import utils.Time;
import utils.UID;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class BankAccount extends BaseEntity<Long> {
    // A balance
    // A isActive
    // C owner
    // A creationDate
    // A accountNumber
    // R outgoingTransactions
    // R incomingTransactions
    // accountPassword
    public static final String COLUMN_BALANCE_NAME = "balance";
    public static final String COLUMN_IS_ACTIVE_NAME = "is_active";
    public static final String COLUMN_CREATION_DATE_NAME = "creation_date";
    public static final String COLUMN_ACCOUNT_NUMBER_NAME = "account_number";
    public static final String COLUMN_ACCOUNT_PASSWORD_NAME = "account_password";

    public BankAccount(Customer owner) {
        this.owner = owner;
    }



    @Column(name = COLUMN_BALANCE_NAME, nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;
    @Column(name = COLUMN_IS_ACTIVE_NAME, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isActive = false;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private Customer owner;
    @Column(name = COLUMN_CREATION_DATE_NAME, nullable = false, updatable = false)
    private Timestamp creationDate;
    @Column(name = COLUMN_ACCOUNT_NUMBER_NAME, nullable = false, unique = true, updatable = false)
    private Long accountNumber=new UID().getNew();
    @OrderBy("transactionAccomplishmentTime desc")
    @OneToMany(mappedBy = "senderBankAccount", orphanRemoval = true)
    private Set<Transaction> outgoingTransactions = new HashSet<>();
    @OrderBy("transactionAccomplishmentTime desc")
    @OneToMany(mappedBy = "receiverBankAccount", orphanRemoval = true)
    private Set<Transaction> incomingTransactions = new HashSet<>();

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JoinColumn(name = "credit_card_id", unique = true)
    private CreditCard creditCard;

    @Column(name = COLUMN_ACCOUNT_PASSWORD_NAME, nullable = false)
    private Long accountPassword= ((long) new Random().nextInt( 9999));

    @PrePersist
    public void prePersist() {

        setCreationDate(new Time().now());


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "balance = " + balance + ", " +
                "isActive = " + isActive + ", " +
                "owner = " + owner.getFullName() + ", " +
                "creationDate = " + creationDate + ", " +
                "accountNumber = " + accountNumber + ")";
    }
}
