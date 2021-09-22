package Service;

import Base.Service.Service;
import Domain.CreditCard;
import Repository.CreditCardRepository;


public class CreditCardService extends Service<CreditCard, Long, CreditCardRepository>
        implements CreditCardServiceApi<CreditCard,Long>{

    public CreditCardService(CreditCardRepository repository) {
        super(repository);
    }


    @Override
    public void sendFromCardToOtherCard() {

    }

    @Override
    public void setPassword() {

    }
}
