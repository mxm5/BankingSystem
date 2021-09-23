package Service;

import Base.Entity.BaseEntity;

import java.io.Serializable;

public interface BankAccountServiceApi<E extends BaseEntity<ID>, ID extends Serializable> {

    void autoDisableAfterThreeFailedLoginTries();

    boolean login();

}
