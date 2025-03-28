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
    @Autowired //-> คุยกับ service
    private OfficeService officeService;

    //สร้าง endpoint เพื่อรองรับ CRUD
    //ไปที่ /api/offices/ จะคืนค่า office ทั้งหมด
    @GetMapping("")
    public List<Office> getAllOffices() {
        return officeService.getAllOffices();
    }

    //ไปที่ /api/offices/id
    @GetMapping("/{id}")
    //@PathVariable เพื่อทำการ map ตัวแปร id ไปไว้ที่ไหน ในฝั่ง backend
    public Office getOffice(@PathVariable String id) {
        return officeService.getOffice(id);
    }

    //การ createOffice
    @PostMapping("")
    //@RequestBody -> การดึงข้อมูลของ JSON ที่ส่งมาใน request
    //@RequestBody -> คือ JSON ที่ frontend ส่งมา ได้มาแล้วแปลงเป็น Object ของ java
    public Office createOffice(@RequestBody Office office) {
        return officeService.createOffice(office); //ส่งOffices ที่ไม่ซ้ำ
    }

    // -> /api/offices/{id}
    @PutMapping("/{id}")
    public Office updateOffice(@PathVariable String id
            , @RequestBody Office office) {
        return officeService.updateOffice(id, office); //Update ข้อมูลใหม่คืออะไร office ที่เป็นข้อมูล
    }

    // -> /api/offices/{id}
    @DeleteMapping("/{id}") //คือการส่ง id มาด้วย
    public void deleteOffice(@PathVariable String id) {
        officeService.deleteOffice(id);
    }

    // ไปที่ /api/offices/{id}/employees -> คือการขอข้อมูล employee ทั้งหมดของ office เพื่อระบุ
    @GetMapping("/{id}/employees")
    public List<Employee> getEmployees(@PathVariable String id) {
        return officeService.getOffice(id).getEmployees();
    }
}
