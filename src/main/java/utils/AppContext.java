package utils;

import Domain.BankEmployee;
import Domain.Branch;
import Domain.Customer;

public class AppContext {

    private static BankEmployee employee;

    private static Customer customer;

    private static Branch userBranch;

    public static Branch getUserBranch() {
        return userBranch;
    }

    public static void setUserBranch(Branch userBranch) {
        AppContext.userBranch = userBranch;
    }

    public static BankEmployee getEmployee() {
        return employee;
    }

    public static void setEmployee(BankEmployee employee) {
        AppContext.employee = employee;
    }

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer customer) {
        AppContext.customer = customer;
    }
}
