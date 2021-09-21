package Domain;

import Base.BasePerson;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import utils.UID;

import javax.persistence.*;
import java.util.Random;

@Entity
@Setter
@Getter
public class BankEmployee extends BasePerson {

    @Column(name = COLUMN_EMPLOYEE_NUMBER_NAME, nullable = false, unique = true, updatable = false)
    private Long employeeNumber;

    public static final String COLUMN_EMPLOYEE_NUMBER_NAME = "employee_number";
    public static final String COLUMN_EMPLOYEE_PASSWORD_NAME = "employee_password";

    @Immutable
    @Column(name = COLUMN_EMPLOYEE_PASSWORD_NAME, nullable = false)
    private String employeePassword;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "hiring_branch_id", nullable = false)
    private Branch hiringBranch;

    @PrePersist
    public void prePersist() {
        setEmployeeNumber(new UID().getNew());
        setEmployeePassword(String.valueOf(new Random().nextInt(1000000,9999999)));
    }
}
