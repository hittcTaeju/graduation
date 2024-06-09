package taeju.graduation.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import taeju.graduation.domain.Competition;
import taeju.graduation.domain.IntegrationEntry;
import taeju.graduation.domain.User;
import taeju.graduation.repository.CompetitionRepository;
import taeju.graduation.repository.IntegrationEntryRepository;
import taeju.graduation.repository.UserRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IntegrationEntryServiceTest {




    @Autowired private IntegrationEntryRepository integrationEntryRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private CompetitionRepository competitionRepository;




    @Test
    @Transactional
    public void saveIntegrationTest(){
        // create user
        User user = new User();
        user.setUsername("user1");
        user.setPassword("1234");
        userRepository.save(user);

        //create competition
        Competition competition = new Competition();
        competition.setName("competition1");
        competitionRepository.save(competition);

        //create IntegrationEntry

        IntegrationEntry integrationEntry = new IntegrationEntry();
        integrationEntry.setEventType("Single");
        integrationEntry.setParticipantName("participant1");
        integrationEntry.setParticipantGrade("3부");
        integrationEntry.setParticipantTeamname("홍익대");
        integrationEntry.setUser(user);
        integrationEntry.setCompetition(competition);

        IntegrationEntry savedEntry = integrationEntryRepository.save(integrationEntry);
    }


}