package sit.int204.classicmodelsapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity //เพื่อบอกว่า class นี้เป็น Entity
@Table(name = "employees") //table employees
@Getter
@Setter
public class Employee {
    //ตัวแรกเราต้องใส่ Id เพื่อบอกว่า employeeNumber เป็น primary key
    @Id
    private Integer employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;

    //ลิ้งจาก Employee ไป Office
    @ManyToOne //ความสัมพันธ์
    @JoinColumn(name = "officeCode") //ตัวcolumn ที่เชื่อมความสัมพันธ์ ที่map กับมา

    private Office office;
    private Integer reportsTo;
    private String jobTitle;
}
