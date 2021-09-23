package Service;

import Base.Service.Service;
import Domain.CreditCard;
import Repository.CreditCardRepository;


public class CreditCardService extends Service<CreditCard, Long, CreditCardRepository>
        implements CreditCardServiceApi<CreditCard,Long>{

    public CreditCardService(CreditCardRepository repository) {
        super(repository);
    }

    //todo set a transaction validated
    @Override
    public void sendFromCardToOtherCard() {

    }

    //todo set a new password only for card
    @Override
    public void setPassword() {

    }
}
