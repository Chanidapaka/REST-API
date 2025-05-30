package sit.int204.classicmodelsapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "offices")
@Getter
@Setter
public class Office {
    //ตัวแรกเราต้องใส่ Id เพื่อบอกว่า officeCode เป็น primary key
    @Id
    private String officeCode;

    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;

    //ความสัมพันธ์
    //map กับ private Office office; ใน employees
    @OneToMany(mappedBy = "office")

    //ข้อมูลนี้จะไม่ถูก Generate เป็น Json
    @JsonIgnore

    private List<Employee> employees; //1 office มีหลาย employess
}
