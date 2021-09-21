package Domain;

import Base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import utils.Time;
import utils.UID;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
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

    @PrePersist
    void setDefaultValues() {
        setCardNumber(new UID().getNew());
        setExpirationDate(new Time().fourYearsFromNow());
        setCreationDate(new Time().now());
        setCvv2(((short) new Random().nextInt(100, 9999)));
        if(cardFourDigitPassword==null) setCardFourDigitPassword(((short) 1111));
    }

    @Immutable
    @Column(name = COLUMN_CARD_NUMBER_NAME, nullable = false, updatable = false)
    private Long cardNumber;

    @Column(name = COLUMN_CARD_FOUR_DIGIT_PASSWORD_NAME, nullable = false)
    private Short cardFourDigitPassword;

    @Column(name = COLUMN_ONLINE_PASSWORD_NAME)
    private Long onlinePassword;

    @Immutable
    @Column(name = COLUMN_CVV2_NAME, nullable = false, updatable = false)
    private Short cvv2;


    @Column(name = COLUMN_EXPIRATION_DATE_NAME, nullable = false)
    private Date expirationDate;


    @Immutable
    @Column(name = COLUMN_CREATION_DATE_NAME, nullable = false, updatable = false)
    private Timestamp creationDate;


}
