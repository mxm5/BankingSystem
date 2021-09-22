package Base.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class BasePerson extends BaseEntity<Long> {

    public static final String COLUMN_NATIONAL_CODE_NAME = "national_code";
    public static final String COLUMN_LASTNAME_NAME = "last_name";
    public static final String COLUMN_FIRSTNAME_NAME = "first_name";

    @Column(name = COLUMN_FIRSTNAME_NAME, nullable = false)
    protected String firstName;

    public String getFullName(){
        return getFirstName()+" "+getLastName();
    }

    @Column(name = COLUMN_LASTNAME_NAME, nullable = false)
    protected String lastName;

    @Column(name = COLUMN_NATIONAL_CODE_NAME, nullable = false, unique = true, updatable = false)
    protected Long nationalCode;



}
