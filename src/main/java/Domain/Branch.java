package Domain;

import Base.Entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import utils.UID;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Branch extends BaseEntity<Long> {

    //A branchNumber
    //R employees
    //R customers
    //C branchName

    @Column(name = COLUMN_BRANCH_NUMBER_NAME)
    private Long branchNumber= new UID().getNew();

    public Branch(String branchName) {
        this.branchName = branchName;
    }

    public static final String COLUMN_BRANCH_NUMBER_NAME = "branch_number";
    public static final String COLUMN_BRANCH_NAME_NAME = "branch_name";

    @OneToMany(mappedBy = "hiringBranch", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private Set<BankEmployee> employees= new HashSet<>();

    @OneToMany(mappedBy = "registeringBranch", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private Set<Customer> customers=new HashSet<>();

    @Column(name = COLUMN_BRANCH_NAME_NAME, nullable = false, unique = true)
    private String branchName;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "branchNumber = " + branchNumber + ", " +
                "branchName = " + branchName + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Branch branch = (Branch) o;
        return Objects.equals(id, branch.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
