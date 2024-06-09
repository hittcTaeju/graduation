package taeju.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taeju.graduation.domain.Competition;
import taeju.graduation.domain.IntegrationEntry;
import taeju.graduation.domain.User;
import taeju.graduation.repository.IntegrationEntryRepository;

import java.util.List;

@Service
public class IntegrationEntryService {
    @Autowired
    private IntegrationEntryRepository integrationEntryRepository;
    public List<IntegrationEntry> getEntriesByUser(User user){
        return integrationEntryRepository.findByUser(user);
    }
    public List<IntegrationEntry> getEntriesByCompetition(Competition competition){
        return integrationEntryRepository.findByCompetition(competition);
    }
    public IntegrationEntry saveIntegrationEntry(IntegrationEntry integrationEntry){
        return integrationEntryRepository.save(integrationEntry);
    }
    public List<IntegrationEntry> getAllEntries() {
        return integrationEntryRepository.findAll();
    }
    public void deleteIntegrationEntry(Long id){
        integrationEntryRepository.deleteById(id);
    }

}
