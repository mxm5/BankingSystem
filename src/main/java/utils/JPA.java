package utils;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JPA {
    @Getter
    private final EntityManagerFactory entityManagerFactory;
    @Getter
    private final EntityManager entityManager;

    private static JPA instance;

    public static JPA getInstance() {
        if(instance == null) instance = new JPA();
        return instance;
    }
    private JPA() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BankingSystem");
        entityManager = entityManagerFactory.createEntityManager();
    }
}
