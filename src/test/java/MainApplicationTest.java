import Domain.BankAccount;
import Domain.Branch;
import Domain.CreditCard;
import Domain.Customer;
import org.junit.jupiter.api.Test;
import utils.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MainApplicationTest {

    @Test
    void nig() {
        {
            EntityManagerFactory bankingSystem = Persistence.createEntityManagerFactory("BankingSystemB");
            EntityManager entityManager = bankingSystem.createEntityManager();
            entityManager.getTransaction().begin();
//        Customer customer = new Customer();
//        customer.setFirstName("mmd");
//        customer.setNationalCode(new UID().getNew());
//        customer.setLastName("xyz");
//        BankAccount bankAccount = new BankAccount();
//        new Customer();
//        new BankAccount();
//        new Branch();
//        new Transaction();
//        new CreditCard();
//        new BankEmployee();
//        bankAccount.setOwner(customer);
            //
            //
            //
            //
            //
            //
            //

            Branch aliabad = new Branch("aliabad");

            entityManager.persist(aliabad);
            Customer customer = new Customer("mohammad", "mohammadian", 27040903499L, aliabad);
            entityManager.persist(customer);
            List<BankAccount> bankAccounts = customer.getBankAccounts().stream().collect(Collectors.toList());
            BankAccount bankAccount = bankAccounts.get(0);
            entityManager.persist(bankAccount);
            CreditCard creditCard = new CreditCard();
            bankAccount.setCreditCard(creditCard);
            entityManager.getTransaction().commit();






        }
    }

    @Test
    void jpa() {

        EntityManager entityManager = JPA.getInstance().getEntityManager();



    }
}