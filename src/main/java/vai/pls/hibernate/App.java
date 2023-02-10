package vai.pls.hibernate;

import vai.pls.hibernate.model.Employee;
import vai.pls.hibernate.model.EmployeesManager;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EmployeesManager employeeManager = new EmployeesManager();
        ArrayList<Long> employeesIDs = new ArrayList<Long>();

        employeesIDs.add(employeeManager.addEmployee("Luca","Rossi",1000.5));
        employeeManager.listAllEmployees();
        employeeManager.updateEmployeeSalary(employeesIDs.get(0),1000.6);
        employeeManager.listAllEmployees();
        employeeManager.fireEmployee(employeesIDs.get(0));
        employeesIDs.add(employeeManager.addEmployee(new Employee("Luca","Rossi",1000)));
        employeeManager.listAllEmployees();
        employeeManager.Stop();
    }
}
