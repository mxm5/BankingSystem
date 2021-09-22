package Service;

import Base.Service.Service;
import Domain.BankAccount;
import Repository.BankAccountRepository;



public class BankAccountService extends Service<BankAccount, Long, BankAccountRepository> {

    public BankAccountService(BankAccountRepository repository) {
        super(repository);
    }


}
