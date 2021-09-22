package Repository;

import Base.Repository.Repository;
import Domain.Branch;

public class BranchRepository extends Repository<Branch,Long> {
    @Override
    public Class<Branch> getType() {
        return Branch.class;
    }
}
