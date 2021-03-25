package uppgift3;

import com.example.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryVersionOfEmployeeRepositoryTest {


    InMemoryVersionOfEmployeeRepository inMemoryVersionOfEmployeeRepository = new InMemoryVersionOfEmployeeRepository();


    @Test
    @DisplayName("Has saved Employee")
    void hasSavedEmployee() {
        Employee employee = new Employee("1", 2000);
        inMemoryVersionOfEmployeeRepository.save(employee);

        assertEquals(1, inMemoryVersionOfEmployeeRepository.findAll().size());

    }

    @Test
    @DisplayName("Overwriting employee")
    void overwritingEmployee() {
        Employee employee = new Employee("1", 2000);
        Employee employee1 = new Employee("1", 2001);
        inMemoryVersionOfEmployeeRepository.save(employee);

        inMemoryVersionOfEmployeeRepository.save(employee1);

        assertEquals(1, inMemoryVersionOfEmployeeRepository.findAll().size());
        assertEquals(2001, inMemoryVersionOfEmployeeRepository.findAll().get(0).getSalary());
    }

    @Test
    @DisplayName("Adding employee with no id")
    void addingEmployeeWithNoId() {
        Employee employee = new Employee("0", 2000);

        inMemoryVersionOfEmployeeRepository.save(employee);


        assertEquals("1", inMemoryVersionOfEmployeeRepository.findAll().get(0).getId());

    }

}