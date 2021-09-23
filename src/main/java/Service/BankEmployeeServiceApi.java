package Service;

import Base.Entity.BaseEntity;
import Domain.BankEmployee;
import Domain.Customer;

import java.io.Serializable;

public interface BankEmployeeServiceApi <E extends BaseEntity<ID>,ID extends Serializable> {

    BankEmployee login(Long eNumber, String ePass);

    Customer registerANewCustomer(          String fName,
                                            String lName,
                                            long nCode) throws Exception;
}
