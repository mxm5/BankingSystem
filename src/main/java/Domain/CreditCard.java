package Domain;

import Base.Entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import utils.Time;
import utils.UID;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Random;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class CreditCard extends BaseEntity<Long> {

    public static final String COLUMN_CARD_NUMBER_NAME = "card_number";
    public static final String COLUMN_CARD_FOUR_DIGIT_PASSWORD_NAME = "card_four_digit_password";
    public static final String COLUMN_ONLINE_PASSWORD_NAME = "online_password";
    public static final String COLUMN_CVV2_NAME = "cvv_2";
    public static final String COLUMN_EXPIRATION_DATE_NAME = "expiration_date";
    public static final String COLUMN_CREATION_DATE_NAME = "creation_date";

    //A cardNumber
    //A cardFourDigitPassword
    //N onlinePassword
    //A cvv2
    //A expirationDate
    //A creationDate
    //R connectedAccount
    @PrePersist
    void setDefaultValues() {
        setCardNumber(new UID().getNew());
        setExpirationDate(new Time().fourYearsFromNow());
        setCreationDate(new Time().now());
        setCvv2(((short) new Random().nextInt( 9999)));
        if(cardFourDigitPassword==null) setCardFourDigitPassword(((short) 1111));
    }

    @Column(name = COLUMN_CARD_NUMBER_NAME, nullable = false, updatable = false)
    private Long cardNumber;

    @Column(name = COLUMN_CARD_FOUR_DIGIT_PASSWORD_NAME, nullable = false)
    private Short cardFourDigitPassword;

    @Column(name = COLUMN_ONLINE_PASSWORD_NAME)
    private Long onlinePassword;

    @Column(name = COLUMN_CVV2_NAME, nullable = false, updatable = false)
    private Short cvv2;


    @Column(name = COLUMN_EXPIRATION_DATE_NAME, nullable = false)
    private Date expirationDate;



    @Column(name = COLUMN_CREATION_DATE_NAME, nullable = false, updatable = false)
    private Timestamp creationDate;

    @OneToOne(mappedBy = "creditCard")
    private BankAccount connectedAccount;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "cardNumber = " + cardNumber + ", " +
                "cvv2 = " + cvv2 + ", " +
                "expirationDate = " + expirationDate + ", " +
                "creationDate = " + creationDate + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
