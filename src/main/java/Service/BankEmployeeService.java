package Service;

import Base.Service.Service;
import Domain.BankEmployee;
import Repository.BankEmployeeRepository;


public class BankEmployeeService extends Service<BankEmployee, Long, BankEmployeeRepository> {

    public BankEmployeeService(BankEmployeeRepository repository) {
        super(repository);
    }


}
