package Repository;

import Base.Repository.Repository;
import Domain.BankEmployee;

public class BankEmployeeRepository extends Repository<BankEmployee,Long>
implements BankEmployeeRepositoryApi<BankEmployee,Long>{
    @Override
    public Class<BankEmployee> getType() {
        return BankEmployee.class;
    }


    @Override
    public BankEmployee findEmployeeByUidAndPass(Long eNumber,String ePass) {
        BankEmployee logged = getEntityManager().createQuery("from " + name() +
                        " e where e.employeeNumber = " + eNumber +
                        " and " + " e.employeePassword =" + ePass,
                BankEmployee.class).getSingleResult();
        return logged;
    }
}
