package sit.int204.classicmodelsapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsapi.entities.Employee;
import sit.int204.classicmodelsapi.entities.Office;
import sit.int204.classicmodelsapi.services.OfficeService;

import java.util.List;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {
    @Autowired
    private OfficeService officeService;

    @GetMapping("")
    public List<Office> getAllOffices() {
        return officeService.getAllOffices();
    }

    @GetMapping("/{id}")
    public Office getOffice(@PathVariable String id) {
        return officeService.getOffice(id);
    }

    @PostMapping("") //@RequestBody ข้อมูลที่อยู่ใน body ของ Request
    public Office createOffice(@RequestBody Office office) {
        return officeService.createOffice(office); //ส่งOffices ที่ไม่ซ้ำ
    }

    @PostMapping("/{id}")
    public Office updateOffice(@PathVariable String id
            , @RequestBody Office office) {
        return officeService.updateOffice(id, office); //Update ข้อมูลใหม่คืออะไร office ที่เป็นข้อมูล
    }
    @DeleteMapping("/{id}") //คือการส่ง id มาด้วย
    public void deleteOffice(@PathVariable String id) {
        officeService.deleteOffice(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployees(@PathVariable String id) {
        return officeService.getOffice(id).getEmployees();
    }
}
