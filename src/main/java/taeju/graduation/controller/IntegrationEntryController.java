package taeju.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import taeju.graduation.domain.IntegrationEntry;
import taeju.graduation.repository.CompetitionRepository;
import taeju.graduation.repository.UserRepository;
import taeju.graduation.service.IntegrationEntryService;

import java.sql.SQLOutput;
import java.util.List;

@Controller
@RequestMapping("/integrationEntries")
public class IntegrationEntryController {
    @Autowired
    private IntegrationEntryService integrationEntryService;
    @Autowired
    private UserRepository userRepository;
    @Autowired private CompetitionRepository competitionRepository;

    @GetMapping("/new")
    public String showEntryForm(Model model){
        //System.out.println("??");
        model.addAttribute("integrationEntry",new IntegrationEntry());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("competitions",competitionRepository.findAll());
        return "/integrationEntries/integrationEntryForm";
    }

    @PostMapping("/new")
    public String saveEntry(@ModelAttribute IntegrationEntry integrationEntry){
        integrationEntryService.saveIntegrationEntry(integrationEntry);
        return "redirect:/integrationEntries/list";
    }

    @GetMapping("/list")
    public String listEntries(Model model){
        List<IntegrationEntry> entries = integrationEntryService.getAllEntries();
       // System.out.println(entries);
        model.addAttribute("entries",entries);
        return "integrationEntries/integrationEntryList";
    }
}
