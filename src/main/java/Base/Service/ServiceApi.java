package Base.Service;

import Base.Entity.BaseEntity;
import utils.Exceptions.EntityNotFoundException;

import java.io.Serializable;
import java.util.Collection;

public interface ServiceApi<E extends BaseEntity<ID>, ID extends Serializable> {
    void save(E e) throws Exception;

    void delete(E e) throws EntityNotFoundException;

    E getById(ID id) throws Exception;

    Collection<E> getAll();

    Collection<E> getChunkOfAll(int chunkSize, int chunkCount);

    void safeRemove(E e);
}
