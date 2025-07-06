package com.example.jpahibernate;
import org.springframework.context.annotation.ComponentScan;

import com.example.entity.Employee;
import com.example.hibernate.EmployeeDaoHibernate;
import com.example.hibernate.HibernateUtil;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan("com.example")
@EnableJpaRepositories(basePackages = "com.example.repository")
@EntityScan(basePackages = "com.example.entity")
public class JpaVsHibernateDemoApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(JpaVsHibernateDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Using Hibernate Native ===");
        EmployeeDaoHibernate hibernateDao = new EmployeeDaoHibernate();
        Integer hId = hibernateDao.addEmployee(new Employee("Ramesh", "HR"));
        System.out.println("Hibernate saved employee ID: " + hId);

        System.out.println("=== Using Spring Data JPA ===");
        Employee springEmp = new Employee("Sita", "Sales");
        Employee savedEmp = employeeService.addEmployee(springEmp);
        System.out.println("Spring Data JPA saved employee: " + savedEmp);

        HibernateUtil.shutdown();
    }
}
