package hello;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author vtarasov
 * @since 22.12.2019
 */
@Controller
public class CaseController {
    @Autowired
    private TestCaseRepository testCaseRepository;

    @PostMapping("submitCase")
    public String addCase(@RequestParam String title, @RequestParam String version, @RequestParam String description, @RequestParam String refs) {
        TestCase testCase = new TestCase();
        testCase.setTitle(title);
        testCase.setVersion(version);
        testCase.setDescription(description);
        testCase.setRefs(refs.lines().collect(Collectors.toUnmodifiableList()));
        testCaseRepository.save(testCase);
        return "redirect:cases";
    }
}
