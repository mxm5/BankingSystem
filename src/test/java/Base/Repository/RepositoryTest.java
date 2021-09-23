package Base.Repository;

import Domain.CreditCard;
import Repository.CreditCardRepository;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Exceptions.EntityMustUseUpdateInsteadOfSave;
import utils.Exceptions.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    CreditCardRepository creditCardRepository;
    @BeforeEach
    void setUp() {
         creditCardRepository = new CreditCardRepository();
    }

    @Test
    void getById() throws Exception {

        assertThrows(EntityNotFoundException.class,()->creditCardRepository.getById(1315L));

    }

    @Test
    void save() {
        CreditCard creditCard = new CreditCard();
        creditCard.setId(2352353L);
        assertThrows(
                EntityMustUseUpdateInsteadOfSave.class,
                ()->creditCardRepository.save(creditCard)
        );

    }

    @Test
    void update() {
        CreditCard creditCard = new CreditCard();
        creditCard.setId(2352353L);
        assertThrows(
                EntityNotFoundException.class,
                ()->creditCardRepository.update(creditCard)
        );
    }
}