package Repository;

import Base.Entity.BaseEntity;
import Domain.BankEmployee;

import java.io.Serializable;

public interface BankEmployeeRepositoryApi <E extends BaseEntity<ID>,ID extends Serializable> {


    BankEmployee findEmployeeByUidAndPass(Long eNumber, String ePass);
}
