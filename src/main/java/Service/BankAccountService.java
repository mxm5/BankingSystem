package Service;

import Base.Service.Service;
import Domain.BankAccount;
import Repository.BankAccountRepository;



public class BankAccountService extends Service<BankAccount, Long, BankAccountRepository> implements
BankAccountServiceApi<BankAccount,Long>{

    public BankAccountService(BankAccountRepository repository) {
        super(repository);
    }


    //todo auto disable customer after 3 failed logins
    @Override
    public void autoDisableAfterThreeFailedLoginTries() {

    }
    // todo create a customer login
    @Override
    public boolean login() {
        return false;
    }
}
