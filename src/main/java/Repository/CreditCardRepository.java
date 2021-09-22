package Repository;

import Base.Repository.Repository;
import Domain.CreditCard;

public class CreditCardRepository extends Repository<CreditCard,Long> {
    @Override
    public Class<CreditCard> getType() {
        return CreditCard.class;
    }
}
