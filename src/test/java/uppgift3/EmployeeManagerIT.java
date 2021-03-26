package uppgift3;

import com.example.BankService;
import com.example.Employee;
import com.example.EmployeeManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class EmployeeManagerIT {

    @Test
    @DisplayName("Is not paid")
    void isNotPaid() {
        //Arrange
        Employee employee = new Employee("0", 2000);
        InMemoryVersionOfEmployeeRepository inMemoryVersionOfEmployeeRepository = new InMemoryVersionOfEmployeeRepository();
        BankService bankService = mock(BankService.class);
        EmployeeManager employeeManager = new EmployeeManager(inMemoryVersionOfEmployeeRepository, bankService);

        //Act
        doThrow(new RuntimeException()).when(bankService).pay("1", 2000);
        inMemoryVersionOfEmployeeRepository.save(employee);
        employeeManager.payEmployees();

        //Assert
        assertFalse(employee.isPaid());
        assertEquals(0, employeeManager.payEmployees());

    }
}
