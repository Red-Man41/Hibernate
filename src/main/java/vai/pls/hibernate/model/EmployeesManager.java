package vai.pls.hibernate.model;

import jakarta.persistence.*;

import java.util.ArrayList;

public class EmployeesManager
{
    private static EntityManagerFactory emFactory;
    private static EntityManager em;

    public EmployeesManager()
    {
        emFactory = Persistence.createEntityManagerFactory("employee_persistence_unit");
        em = emFactory.createEntityManager();
    }

    public long addEmployee(Employee employee)
    {
        EntityTransaction tx = em.getTransaction();
        Long id = null;


        try
        {
            tx.begin();
            em.persist(employee);
            id = em.find(Employee.class, employee.getId()).getId();
            if (id == null)
                throw new RollbackException();
            tx.commit();
        }
        catch (RollbackException e)
        {
            tx.rollback();
            System.out.printf("Error:\n%s\n",e);
            e.printStackTrace();

            return -1;
        }

        return id;
    }


    public long addEmployee(String firstName, String lastName, double salary)
    {
        return addEmployee(new Employee(firstName, lastName, salary));
    }

    public void listAllEmployees()
    {
        EntityTransaction tx = em.getTransaction();

        try
        {
            tx.begin();

            ArrayList<Employee> employees = new ArrayList<Employee>(em.createQuery("from Employee").getResultList());

            for (Employee employee : employees)
            {
                System.out.println(employee);
            }

            tx.commit();
        }
        catch (RollbackException e)
        {
            tx.rollback();
            System.out.printf("Error:\n%s\n",e);
            e.printStackTrace();
        }
    }

    public void updateEmployeeSalary(Long employeeID, double newSalary)
    {
        EntityTransaction tx = em.getTransaction();

        try
        {
            Employee employee = em.find(Employee.class, employeeID);
            employee.setSalary(newSalary);

            tx.begin();
            tx.commit();
        }
        catch (RollbackException e)
        {
            tx.rollback();
            System.out.printf("Error:\n%s\n",e);
            e.printStackTrace();
        }
    }

    public void fireEmployee(Long employeeID)
    {
        EntityTransaction tx = em.getTransaction();

        try
        {
            tx.begin();

            Employee employee = em.find(Employee.class, employeeID);
            em.remove(employee);

            tx.commit();
        }
        catch (RollbackException e)
        {
            tx.rollback();
            System.out.printf("Error:\n%s\n",e);
            e.printStackTrace();
        }
    }

    public void Stop()
    {
        em.close();
        emFactory.close();
    }
}
