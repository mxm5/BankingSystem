package Service;

import Base.Service.Service;
import Domain.BankEmployee;
import Domain.Customer;
import Repository.BankEmployeeRepository;
import Repository.CustomerRepository;
import utils.Services;


public class BankEmployeeService extends Service<BankEmployee, Long, BankEmployeeRepository>
        implements BankEmployeeServiceApi<BankEmployee, Long> {

    CustomerRepository customerRepository = new CustomerRepository();

    public BankEmployeeService(BankEmployeeRepository repository) {

        super(repository);
    }


    // 1 todo implement login for the employee
    @Override
    public BankEmployee login(Long eNumber, String ePass) {
        return repository.findEmployeeByUidAndPass(eNumber
                , ePass);
    }

    @Override
    public Customer registerANewCustomer(String fName, String lName, long nCode) throws Exception {
        Customer customer = new Customer(
                fName,
                lName,
                nCode,
                Services.getUserBranch()
        );
        customerRepository.save(
                customer
        );
        return customer;
    }
    //  todo register a customer

    // todo update info
    // todo activate customer account
    // todo remove a customer
    // todo get info for a customer


    // todo add money to an account

    // todo subtract money from account

}
