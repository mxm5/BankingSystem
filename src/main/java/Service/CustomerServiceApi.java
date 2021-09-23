package Service;

import Base.Entity.BaseEntity;

import java.io.Serializable;
import java.util.Collection;

public interface CustomerServiceApi<E extends BaseEntity<ID>, ID extends Serializable> {


   Collection<E> getAllAccountsByCustomerId();
   Collection<E> getAllAccountsByCustomerNumber();


}
