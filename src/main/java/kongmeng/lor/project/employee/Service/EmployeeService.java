package kongmeng.lor.project.employee.Service;

import kongmeng.lor.project.employee.entity.Employee;
import kongmeng.lor.project.employee.exception.UserNotFoundException;
import kongmeng.lor.project.employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmplyee(Employee employee) {
        employee.setCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
    public Employee findEmployeeById(Long id)  {
        return employeeRepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("User by id " + id + " was not found."));
    }

}
