package Domain;

import Base.Entity.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import utils.UID;

import javax.persistence.*;
import java.util.Objects;
import java.util.Random;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class BankEmployee extends Person {
    public static final String COLUMN_EMPLOYEE_NUMBER_NAME = "employee_number";
    public static final String COLUMN_EMPLOYEE_PASSWORD_NAME = "employee_password";

//    (C)(M) firstName
//    (C)(M) lastName
//    (C)(M) nationalCode
//    (A)(M) employeeNumber
//    (A)(M) employeePassword
//    (C)(R)(M) hiringBranch

    public BankEmployee(String firstName, String lastName, Long nationalCode, Branch hiringBranch) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.hiringBranch = hiringBranch;
    }

    public BankEmployee(Long employeeNumber, String employeePassword) {
        this.employeeNumber = employeeNumber;
        this.employeePassword = employeePassword;
    }

    @Column(name = COLUMN_EMPLOYEE_NUMBER_NAME, nullable = false, unique = true, updatable = false)
    private Long employeeNumber=new UID().getNew();

    @Column(name = COLUMN_EMPLOYEE_PASSWORD_NAME, nullable = false)
    private String employeePassword;

    {
        Random random = new Random();
        employeePassword = String.valueOf(random.nextInt( 9999999));
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "hiring_branch_id", nullable = false)
    private Branch hiringBranch;




    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "firstName = " + getFirstName() + ", " +
                "lastName = " + getLastName() + ", " +
                "nationalCode = " + getNationalCode() + ", " +
                "employeeNumber = " + getEmployeeNumber() + ", " +
                "hiringBranch = " + getHiringBranch() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BankEmployee that = (BankEmployee) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
