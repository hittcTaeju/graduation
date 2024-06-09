package taeju.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taeju.graduation.domain.Competition;

public interface CompetitionRepository extends JpaRepository<Competition,Long> {
}
