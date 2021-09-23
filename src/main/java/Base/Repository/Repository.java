package Base.Repository;

import Base.Entity.BaseEntity;
import utils.Exceptions.EntityMustUseUpdateInsteadOfSave;
import utils.Exceptions.EntityNotFoundException;
import utils.JPA;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.Collection;

public abstract class Repository<E extends BaseEntity<ID>, ID extends Serializable> implements RepositoryApi<E, ID> {

    private final EntityManager entityManager;

    public abstract Class<E> getType();

    public Repository() {
        entityManager = JPA.getInstance().getEntityManager();
    }


    public EntityTransaction getTransaction() {
        if (entityManager.isOpen())
            return entityManager.getTransaction();
        else throw new IllegalStateException();
    }

    public EntityManager getEntityManager() {
        if (entityManager.isOpen())
            return entityManager;
        else throw new IllegalStateException();
    }

    @Override
    public void save(E e) throws Exception {
        if (!entityManager.isOpen())
            throw new IllegalStateException();
        if (e.getId() == null) {
            EntityTransaction transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                entityManager.persist(e);
                transaction.commit();
            } catch (Exception exception) {
                if (transaction.isActive()) transaction.rollback();
                exception.printStackTrace();

            }
        } else throw new
                EntityMustUseUpdateInsteadOfSave(
                "the entities with id must be updated not saved"
        );
//        EntityTransaction transaction = entityManager.getTransaction();
//        try {
//            transaction.begin();
//            entityManager.merge(e);
//            transaction.commit();
//        } catch (Exception exception) {
//            if (transaction.isActive()) transaction.rollback();
//        }
    }


    @Override
    public void update(E e) throws Exception {
        E elementInDb = entityManager.find(getType(), e.getId());
        if (e.getId() == null || elementInDb == null) {
            throw new EntityNotFoundException(" the entity does not exist in database ");
        }

        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(e);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction.isActive()) transaction.rollback();
        }
    }

    @Override
    public void delete(E e) throws EntityNotFoundException {
        E elementInDB = entityManager.find(getType(), e.getId());
        if (elementInDB == null) {
            throw new EntityNotFoundException(" the entity does not exist in database ");
        }
        entityManager.getTransaction().begin();
        entityManager.remove(e);
        entityManager.getTransaction().commit();
    }

    @Override
    public E getById(ID id) throws Exception {
        E entity = entityManager.find(getType(), id);
        if (entity == null) throw new EntityNotFoundException(" the entity does not exist in database ");
        return entity;
    }

    @Override
    public Collection<E> getAll() {

        return entityManager.
                createQuery("from " + getType().getSimpleName(), getType()).getResultList();
    }

    @Override
    public Collection<E> getChunkOfAll(int chunkSize, int chunkCount) {
        return entityManager.
                createQuery("from " + getType().getSimpleName(), getType()).setMaxResults(chunkSize).setFirstResult(chunkCount * chunkSize).getResultList();

    }

    @Override
    public String name() {
        return getType().getSimpleName();
    }
}
