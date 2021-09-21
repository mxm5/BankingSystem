package Domain;

import Base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
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
public class BankAccount extends BaseEntity<Long> {
    public static final String COLUMN_BALANCE_NAME = "balance";
    public static final String COLUMN_IS_ACTIVE_NAME = "is_active";
    public static final String COLUMN_CREATION_DATE_NAME = "creation_date";
    public static final String COLUMN_ACCOUNT_NUMBER_NAME = "account_number";

    @PrePersist
    public void prePersist() {
        setAccountNumber(new UID().getNew());
        setCreationDate(new Time().now());


    }


    @Column(name = COLUMN_BALANCE_NAME, nullable = false)
    private Long balance= 0L;

    @Column(name = COLUMN_IS_ACTIVE_NAME, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isActive =false;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "owner_id")
    private Customer owner;

    @Immutable
    @Column(name = COLUMN_CREATION_DATE_NAME, nullable = false, updatable = false)
    private Timestamp creationDate;

    @Immutable
    @Column(name = COLUMN_ACCOUNT_NUMBER_NAME, nullable = false, unique = true, updatable = false)
    private Long accountNumber;

    @OrderBy("transactionAccomplishmentTime desc")
    @OneToMany(mappedBy = "senderBankAccount", orphanRemoval = true)
    private List<Transaction> outgoingTransactions;

    @OrderBy("transactionAccomplishmentTime desc")
    @OneToMany(mappedBy = "receiverBankAccount", orphanRemoval = true)
    private List<Transaction> incomingTransactions;

}
