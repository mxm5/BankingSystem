package Repository;

import Base.Repository.Repository;
import Domain.Customer;

public class CustomerRepository extends Repository<Customer,Long> {
    @Override
    public Class<Customer> getType() {
        return Customer.class;
    }
}
