package Base.Repository;

import Base.Entity.BaseEntity;
import utils.Exceptions.EntityNotFoundException;

import java.io.Serializable;
import java.util.Collection;

public interface RepositoryApi<E extends BaseEntity<ID>,ID extends Serializable> {
    E getById(ID id) throws Exception;

    void save(E e) throws Exception;


    void update(E e) throws Exception;

    void delete(E e) throws EntityNotFoundException;

    Collection<E> getAll();

    Collection<E> getChunkOfAll(int chunkSize, int chunkCount);

    String name();

}
