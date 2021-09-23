package Service;

import Base.Entity.BaseEntity;

import java.io.Serializable;

public interface CreditCardServiceApi <E extends BaseEntity<ID>,ID extends Serializable> {
    //crud done
    void sendFromCardToOtherCard();
    void setPassword();

}
