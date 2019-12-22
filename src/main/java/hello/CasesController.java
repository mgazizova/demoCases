package hello;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author vtarasov
 * @since 22.12.2019
 */
@Controller
@RequestMapping("cases")
public class CasesController {
    @Autowired
    private TestCaseRepository testCaseRepository;

    @GetMapping
    public String listCases(Model model) {
        List<TestCase> cases = testCaseRepository.findAll(Sort.by("title"));
        model.addAttribute("cases", cases);
        return "cases";
    }
}
