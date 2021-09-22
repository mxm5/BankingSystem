package Repository;

import Base.Repository.Repository;
import Domain.BankEmployee;

public class BankEmployeeRepository extends Repository<BankEmployee,Long> {
    @Override
    public Class<BankEmployee> getType() {
        return BankEmployee.class;
    }
}
