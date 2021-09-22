package Repository;

import Base.Repository.Repository;
import Domain.BankAccount;

public class BankAccountRepository extends Repository<BankAccount,Long> {
    @Override
    public Class<BankAccount> getType() {
        return BankAccount.class;
    }
}
