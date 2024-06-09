package taeju.graduation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class IntegrationEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventType;
    private String participantName;
    private String participantGrade;
    private String participantTeamname;

    @ManyToOne
    private User user;
    @ManyToOne
    private Competition competition;
}
