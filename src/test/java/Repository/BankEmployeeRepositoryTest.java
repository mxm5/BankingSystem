package Repository;

import Domain.BankEmployee;
import Domain.Branch;
import org.junit.jupiter.api.Test;
import utils.Exceptions.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class BankEmployeeRepositoryTest {

    @Test
    void findEmployeeByUidAndPass() {

        BankEmployeeRepository bankEmployeeRepository = new BankEmployeeRepository();
        Branch c23 = new Branch("c2f453");
        BankEmployee bankEmployee = new BankEmployee("a","b",122345L,
                c23  );
        try{
            System.out.println("===============================");
            System.out.println(bankEmployee);
            Long employeeNumber = bankEmployee.getEmployeeNumber();
            try {
                bankEmployeeRepository.save(bankEmployee);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String employeePassword = bankEmployee.getEmployeePassword();


            BankEmployee logged = bankEmployeeRepository.findEmployeeByUidAndPass(employeeNumber,employeePassword);
            System.out.println("===============");
            System.out.println(logged);
            assertEquals(
                    logged,
                    bankEmployee
            );
        }finally {
            try {
                bankEmployeeRepository.delete(bankEmployee);
                new BranchRepository().delete(c23);
            } catch (EntityNotFoundException e) {
                e.printStackTrace();
            }
        }


    }
}