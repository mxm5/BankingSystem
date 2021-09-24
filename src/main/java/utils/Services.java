package utils;

import Base.Entity.Person;
import Domain.BankEmployee;
import Domain.Branch;
import Domain.Customer;
import Repository.*;
import Service.*;
import lombok.Getter;
import lombok.Setter;

public class Services {
    public static BankAccountService account = null;
    public static BankEmployeeService employee = null;
    public static BranchService branch = null;
    public static CreditCardService card = null;
    public static CustomerService customer = null;
    public static TransactionService traction = null;

    public static Person loggedUser = null;

    private static Branch userBranch = null;

    public static Person getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(Person loggedUser) {
        Services.loggedUser = loggedUser;
    }

    public static Branch getUserBranch() {
        return userBranch;
    }

    public static void setUserBranch(Branch userBranch) {
        Services.userBranch = userBranch;
    }

    static {
        account = new BankAccountService(new BankAccountRepository());
        employee = new BankEmployeeService(new BankEmployeeRepository());
        branch = new BranchService(new BranchRepository());
        card = new CreditCardService(new CreditCardRepository());
        customer = new CustomerService(new CustomerRepository());
        traction = new TransactionService(new TransactionRepository());

    }
}
