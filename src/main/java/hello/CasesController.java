package hello;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author vtarasov
 * @since 22.12.2019
 */
@Controller
public class CasesController {
    @Autowired
    private TestCaseRepository testCaseRepository;

    @GetMapping("/cases")
    public String list(Model model) {
        List<TestCase> cases = testCaseRepository.findAll(Sort.by("title"));
        model.addAttribute("cases", cases);
        return "cases";
    }

    @GetMapping("/cases/{caseId}")
    public String select(@PathVariable int caseId, Model model) {
        TestCase testCase = testCaseRepository.findById(caseId).get();
        model.addAttribute("id", testCase.getId());
        model.addAttribute("title", testCase.getTitle());
        model.addAttribute("version", testCase.getVersion());
        model.addAttribute("description", testCase.getDescription().replace("\n", "<br>"));
        model.addAttribute("refs", String.join("<br>", testCase.getRefs()));
        return "case";
    }

    @PostMapping("/createCase")
    public String create(@RequestParam String title, @RequestParam String version, @RequestParam String description, @RequestParam String refs) {
        TestCase testCase = new TestCase();
        testCase.setTitle(title);
        testCase.setVersion(version);
        testCase.setDescription(description);
        testCase.setRefs(refs.lines().collect(Collectors.toUnmodifiableList()));
        testCaseRepository.save(testCase);
        return "redirect:cases";
    }

    @PostMapping("/deleteCase")
    public String delete(@RequestParam int caseId) {
        testCaseRepository.deleteById(caseId);
        return "redirect:cases";
    }

    @GetMapping("/editCaseForm/{caseId}")
    public String editForm(@PathVariable int caseId, Model model) {
        TestCase testCase = testCaseRepository.findById(caseId).get();
        model.addAttribute("id", testCase.getId());
        model.addAttribute("title", testCase.getTitle());
        model.addAttribute("version", testCase.getVersion());
        model.addAttribute("description", testCase.getDescription());
        model.addAttribute("refs", String.join("\n", testCase.getRefs()));
        return "editCase";
    }

    @PostMapping("/editCase")
    public String edit(@RequestParam int caseId, @RequestParam String title, @RequestParam String version, @RequestParam String description,
        @RequestParam String refs) {
        TestCase testCase = testCaseRepository.findById(caseId).get();
        testCase.setTitle(title);
        testCase.setVersion(version);
        testCase.setDescription(description);
        testCase.setRefs(refs.lines().collect(Collectors.toList()));
        testCaseRepository.save(testCase);
        return "redirect:cases/" + caseId;
    }
}
