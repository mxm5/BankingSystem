package Domain;

import Base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.UID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Branch extends BaseEntity<Long> {
    @Column(name = COLUMN_BRANCH_NUMBER_NAME)
    private Long branchNumber= new UID().getNew();

    public static final String COLUMN_BRANCH_NUMBER_NAME = "branch_number";

    @OneToMany(mappedBy = "hiringBranch", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private List<BankEmployee> employees;

    @OneToMany(mappedBy = "registeringBranch", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Customer> customers;

}
