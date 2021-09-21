import Domain.BankAccount;
import Domain.Customer;
import utils.UID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Random;
import java.util.UUID;

public class MainApplication {
    public static void main(String[] args) {
        EntityManagerFactory bankingSystem = Persistence.createEntityManagerFactory("BankingSystem");
        EntityManager entityManager = bankingSystem.createEntityManager();
        entityManager.getTransaction().begin();
        Customer customer = new Customer();
        customer.setFirstName("mmd");
        customer.setNationalCode(new UID().getNew());
        customer.setLastName("xyz");
        BankAccount bankAccount = new BankAccount();
        bankAccount.setOwner(customer);
        entityManager.persist(bankAccount);

        entityManager.getTransaction().commit();
    }
}
