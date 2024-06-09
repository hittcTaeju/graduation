package taeju.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import taeju.graduation.domain.Competition;
import taeju.graduation.domain.IntegrationEntry;
import taeju.graduation.domain.User;
import taeju.graduation.service.CompetitionService;
import taeju.graduation.service.IntegrationEntryService;
import taeju.graduation.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class CompetitionController {
    @Autowired private IntegrationEntryService integrationEntryService;
    @Autowired private CompetitionService competitionService;
    @Autowired private UserService userService;

    @GetMapping("/")
    public String showHome(Model model){
        model.addAttribute("competitions", competitionService.getAllCompetitions());
        return "home";
    }
    @GetMapping("/competition/{id}")
    public String showCompetitionDetails(@PathVariable("id") Long id, Model model) {
        Competition competition = competitionService.getCompetitionById(id);
        List<IntegrationEntry> entries = competition.getIntegrationEntries();
        model.addAttribute("competition", competition);
        model.addAttribute("entries", entries);
        return "competitionDetails";
    }
    @GetMapping("/competition/new")
    public String showCreateCompetitionForm(Model model){
        model.addAttribute("competition",new Competition());
        return "create-competition";
    }
    @PostMapping("/competition/new")
    public String createCompetition(@ModelAttribute Competition competition){
        competitionService.saveCompetition(competition);
        return "/";
    }






}
