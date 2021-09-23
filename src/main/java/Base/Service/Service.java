package Base.Service;

import Base.Entity.BaseEntity;
import Base.Repository.Repository;
import utils.Exceptions.EntityNotFoundException;

import java.io.Serializable;
import java.util.Collection;

public class
Service<E extends BaseEntity<ID>, ID extends Serializable, R extends Repository<E, ID>>
        implements ServiceApi<E, ID> {

    public R repository;

    public Service(R repository) {
        this.repository = repository;
    }

    @Override
    public void save(E e) {
        try {
            repository.save(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(E e) throws EntityNotFoundException {
        repository.delete(e);
    }

    @Override
    public E getById(ID id) throws Exception {
        return repository.getById(id);
    }

    @Override
    public Collection<E> getAll() {
        return repository.getAll();
    }

    @Override
    public Collection<E> getChunkOfAll(int chunkSize, int chunkCount) {
        return repository.getChunkOfAll(chunkSize, chunkCount);
    }

    @Override
    public void safeRemove(E e) {

    }
}
