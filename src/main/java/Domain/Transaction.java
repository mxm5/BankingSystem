package Domain;

import Base.Entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import utils.Time;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor

public class Transaction extends BaseEntity<Long> {

    public static final String COLUMN_TRANSACTION_ACCOMPLISHMENT_TIME_NAME = "transaction_accomplishment_time";
    public static final String COLUMN_AMOUNT_NAME = "amount";
    public static final String COLUMN_SENDER_BANK_ACCOUNT_NAME = "sender_bank_account_id";
    public static final String COLUMN_SUCCESS_NAME = "success";

    @PrePersist
    void checkSenderAndReceiverNotSame() throws Exception {
        if (receiverBankAccount.equals(senderBankAccount))
            throw new Exception("receiver and sender cant be same");
    }


    public Transaction(Long amount,
                       BankAccount senderBankAccount,
                       BankAccount receiverBankAccount) {
        setTransactionAccomplishmentTime(new Time().now());
        this.amount = amount;
        this.senderBankAccount = senderBankAccount;
        this.receiverBankAccount = receiverBankAccount;
    }

    @Column(name = COLUMN_TRANSACTION_ACCOMPLISHMENT_TIME_NAME, nullable = false, updatable = false)
    private Timestamp transactionAccomplishmentTime;

    @Column(name = COLUMN_AMOUNT_NAME, nullable = false, updatable = false)
    private Long amount;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "sender_bank_account_id", nullable = false, updatable = false)
    private BankAccount senderBankAccount;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "receiver_bank_account_id", nullable = false, updatable = false)
    private BankAccount receiverBankAccount;


    @Column(name = COLUMN_SUCCESS_NAME, nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean success = false;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Transaction that = (Transaction) o;
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
                "transactionAccomplishmentTime = " + transactionAccomplishmentTime + ", " +
                "amount = " + amount + ", " +
                "senderBankAccount = " + senderBankAccount + ", " +
                "receiverBankAccount = " + receiverBankAccount + ", " +
                "success = " + success + ")";
    }
}
