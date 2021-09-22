package Service;

import Base.Entity.BaseEntity;

import java.io.Serializable;

public interface CreditCardServiceApi <E extends BaseEntity<ID>,ID extends Serializable> {
    //crud done
    void sendFromCardToOtherCard();
    //todo validate get second pass cvv2 exp sub 600 Tomans and not disabled
    void setPassword();
    //todo set a new password
}
