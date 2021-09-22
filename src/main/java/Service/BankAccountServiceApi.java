package Service;

import Base.Entity.BaseEntity;

import java.io.Serializable;

public interface BankAccountServiceApi<E extends BaseEntity<ID>, ID extends Serializable> {
    // todo disable account auto
    void autoDisableAfterThreeFailedLoginTries();
}
