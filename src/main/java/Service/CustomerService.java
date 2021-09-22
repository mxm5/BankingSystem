package Service;

import Base.Service.Service;
import Domain.Customer;
import Repository.CustomerRepository;

import java.util.Collection;


public class CustomerService extends Service<Customer, Long, CustomerRepository>
implements CustomerServiceApi<Customer,Long>{

    public CustomerService(CustomerRepository repository) {
        super(repository);
    }


    @Override
    public Collection<Customer> getAllAccountsByCustomerId() {
        return null;
    }

    @Override
    public Collection<Customer> getAllAccountsByCustomerNumber() {
        return null;
    }
}
