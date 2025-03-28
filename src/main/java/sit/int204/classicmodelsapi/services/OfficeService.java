package sit.int204.classicmodelsapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsapi.entities.Office;
import sit.int204.classicmodelsapi.repositories.OfficeRepository;
import java.util.List;

@Service
public class OfficeService {
    @Autowired //-> เพื่อให้ไปคุยกับ repo
    private OfficeRepository officeRepository;

    //ดึงข้อมูล Office ทั้งหมด โดยเรียกใช้ Method findAll() ของ OfficeRepository และส่งคืนเป็น List<Office>.
    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    //ดึงข้อมูล Office ตาม id ที่ระบุ โดยเรียกใช้ Method findById(id) ของ OfficeRepository ซึ่งจะคืนค่าเป็น Optional<Office>.
    public Office getOffice(String id) {
        // เพื่อตรวจสอบว่ามี Office ที่มี id นั้นอยู่ในระบบจริงหรือไม่ ถ้าไม่มีจะ Throw Exception ออกมา
        return officeRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Office id "+ id + " not found"
                )
        );
    }

    //Object Office เป็น Parameter และเรียกใช้ Method save(office) ของ OfficeRepository
    //ซึ่งจะทำการบันทึกข้อมูล Office ลงในฐานข้อมูล และคืนค่า Office ที่ถูกบันทึกแล้ว (อาจมีการเปลี่ยนแปลงค่าบางอย่าง เช่น id ที่ถูกสร้างโดยฐานข้อมูล)
    public Office createOffice(Office office) {
        return officeRepository.save(office);
    }

    public Office updateOffice(String id, Office office) {
        // เรียกใช้ Method getOffice(id)
        //office ที่ต้องการ update
        getOffice(id);

        //กำหนดค่า officeCode ของ Object Office ที่รับเข้ามาให้เป็น id ที่ระบุ
        office.setOfficeCode(id);

        //เรียกใช้ Method save(office) ของ OfficeRepository
        return officeRepository.save(office);
    }
    public void deleteOffice(String id) {
        // เรียกใช้ Method getOffice(id)
        getOffice(id);

        //เรียกใช้ Method deleteById(id) ของ OfficeRepository
        officeRepository.deleteById(id);
    }
}
