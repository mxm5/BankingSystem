package Domain;

import Base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import utils.Time;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@Immutable
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

    public Transaction(Long amount, BankAccount senderBankAccount, BankAccount receiverBankAccount) {
        setTransactionAccomplishmentTime(new Time().now());
        this.amount = amount;
        this.senderBankAccount = senderBankAccount;
        this.receiverBankAccount = receiverBankAccount;
    }

    @Immutable
    @Column(name = COLUMN_TRANSACTION_ACCOMPLISHMENT_TIME_NAME, nullable = false, updatable = false)
    private Timestamp transactionAccomplishmentTime;

    @Immutable
    @Column(name = COLUMN_AMOUNT_NAME, nullable = false, updatable = false)
    private Long amount;

    @Immutable
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "sender_bank_account_id", nullable = false, updatable = false)
    private BankAccount senderBankAccount;

    @Immutable
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "receiver_bank_account_id", nullable = false, updatable = false)
    private BankAccount receiverBankAccount;


    @Column(name = COLUMN_SUCCESS_NAME, nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean success = false;


}
