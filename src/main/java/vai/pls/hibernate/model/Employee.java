package vai.pls.hibernate.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "salary")
    private double salary;

    public Employee()
    {}

    public Employee(String firstName, String lastName, double salary)
    {
        this.firstName = new String(firstName);
        this.lastName = new String(lastName);
        this.salary = salary;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = new String(firstName);
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = new String(lastName);
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    @Override
    public String toString()
    {
        return String.format("Student: \nID: %d\nFirst name: %s\nLast name: %s\nSalary: %f", id, firstName, lastName, salary);
    }
}
