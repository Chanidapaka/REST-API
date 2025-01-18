package sit.int204.classicmodelsapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {
    @Id
    private Integer employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    @ManyToOne
    @JoinColumn(name = "officeCode")
    private Office office;

    private Integer reportsTo;
    private String jobTitle;
}
