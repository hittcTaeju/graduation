package taeju.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taeju.graduation.domain.Competition;
import taeju.graduation.repository.CompetitionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionService {
    @Autowired
    private CompetitionRepository competitionRepository;
    public List<Competition> getAllCompetitions(){
        return competitionRepository.findAll();
    }

    public Competition getCompetitionById(Long id){
        Optional<Competition> optionalCompetition = competitionRepository.findById(id);
        return optionalCompetition.orElse(null);
    }
    public Competition saveCompetition(Competition competition){
        return competitionRepository.save(competition);
    }
    public void deleteCompetition(Long id){
        competitionRepository.deleteById(id);
    }
}
