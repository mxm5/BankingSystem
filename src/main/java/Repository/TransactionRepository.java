package Repository;

import Base.Repository.Repository;
import Domain.Transaction;

public class TransactionRepository extends Repository<Transaction,Long> {
    @Override
    public Class<Transaction> getType() {
        return Transaction.class;
    }
}
