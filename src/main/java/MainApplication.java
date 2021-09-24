import Domain.*;
import utils.Exceptions.EntityNotFoundException;
import utils.JPA;
import utils.Services;
import utils.UID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) throws EntityNotFoundException {


        Branch branch = new Branch("lll ll");

        EntityManager entityManager = JPA.getInstance().getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(branch);
        entityManager.getTransaction().commit();
        System.out.println(branch.getId()+"===================");
        entityManager.getTransaction().begin();
        entityManager.remove(branch);
        entityManager.getTransaction().commit();
//        try {
//            Services.employee.registerANewCustomer("x", "y", 1L);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//
//        }


    }
}
