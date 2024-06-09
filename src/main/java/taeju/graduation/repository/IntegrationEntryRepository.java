package taeju.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taeju.graduation.domain.Competition;
import taeju.graduation.domain.IntegrationEntry;
import taeju.graduation.domain.User;

import java.util.List;

public interface IntegrationEntryRepository extends JpaRepository<IntegrationEntry,Long> {
    List<IntegrationEntry> findByUser(User user);
    List<IntegrationEntry> findByCompetition(Competition competition);

}
