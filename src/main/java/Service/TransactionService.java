package Service;

import Base.Service.Service;
import Domain.Transaction;
import Repository.TransactionRepository;


public class TransactionService extends Service<Transaction, Long, TransactionRepository> {

    public TransactionService(TransactionRepository repository) {
        super(repository);
    }


}
