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
    @Autowired
    private OfficeRepository officeRepository;

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }
    public Office getOffice(String id) {
        return officeRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Office id "+ id + " not found"
                )
        );
    }
    public Office createOffice(Office office) {
        return officeRepository.save(office);
    }
    public Office updateOffice(String id, Office office) {
        getOffice(id);
        office.setOfficeCode(id);
        return officeRepository.save(office);
    }
    public void deleteOffice(String id) {
        getOffice(id);
        officeRepository.deleteById(id);
    }
}
