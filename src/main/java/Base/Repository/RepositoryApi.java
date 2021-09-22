package Base.Repository;

import Base.Entity.BaseEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface RepositoryApi<E extends BaseEntity<ID>,ID extends Serializable> {
    Optional<E> getById(ID id);//todo validation

    void save(E e) throws Exception;
    // todo validation update must be separate from persist

    void delete(E e); // todo validation

    Collection<E> getAll();

    Collection<E> getChunkOfAll(int chunkSize, int chunkCount);

}
