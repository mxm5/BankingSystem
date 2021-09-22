package Service;

import Base.Service.Service;
import Domain.Branch;
import Repository.BranchRepository;


public class BranchService extends Service<Branch, Long, BranchRepository> {

    public BranchService(BranchRepository repository) {
        super(repository);
    }


}
