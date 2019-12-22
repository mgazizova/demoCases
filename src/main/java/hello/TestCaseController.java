package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class TestCaseController {

    @Autowired
    TestCaseRepository testCaseRepository;

    // Получить все записи
    @GetMapping("/testcase")
    public ArrayList getAllNotes() {
        return (ArrayList) testCaseRepository.findAll();
    }

}
