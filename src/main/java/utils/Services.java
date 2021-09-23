package utils;

import Base.Entity.Person;
import Domain.BankEmployee;
import Domain.Branch;
import Domain.Customer;
import Repository.*;
import Service.*;

public class Services {
    public static BankAccountService account = new BankAccountService(new BankAccountRepository());
    public static BankEmployeeService employee = new BankEmployeeService(new BankEmployeeRepository());
    public static BranchService branch = new BranchService(new BranchRepository());
    public static CreditCardService card = new CreditCardService(new CreditCardRepository());
    public static CustomerService customer = new CustomerService(new CustomerRepository());
    public static TransactionService traction = new TransactionService(new TransactionRepository());
    public static Person loggedUser = null;

    {
    }
}
