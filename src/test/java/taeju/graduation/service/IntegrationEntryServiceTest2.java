package taeju.graduation.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import taeju.graduation.domain.IntegrationEntry;
import taeju.graduation.domain.User;
import taeju.graduation.repository.IntegrationEntryRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class IntegrationEntryServiceTest2 {
    @Mock
    private IntegrationEntryRepository integrationEntryRepository;

    @InjectMocks
    private IntegrationEntryService integrationEntryService;

    @Test

    public void testFindByUser() {
        // 가짜 사용자 생성
        User user = new User();
        user.setId(1L);
        user.setUsername("testUser");

        // 가짜 IntegrationEntry 데이터 생성
        IntegrationEntry entry1 = new IntegrationEntry();
        entry1.setId(1L);
        entry1.setEventType("Test Event 1");
        entry1.setUser(user);

        IntegrationEntry entry2 = new IntegrationEntry();
        entry2.setId(2L);
        entry2.setEventType("Test Event 2");
        entry2.setUser(user);

        // IntegrationEntryService의 findByUser 메서드 호출
        List<IntegrationEntry> entries = integrationEntryService.getEntriesByUser(user);

        // 결과 확인
        assertThat(entries).isNotNull();

    }
    @Test
    public void testGetEntriesByUserWithNull() {
        // 가짜 IntegrationEntry 데이터 생성
        IntegrationEntry entry1 = new IntegrationEntry();
        entry1.setId(1L);
        entry1.setEventType("Test Event 1");

        IntegrationEntry entry2 = new IntegrationEntry();
        entry2.setId(2L);
        entry2.setEventType("Test Event 2");

        // IntegrationEntryRepository의 findAll 메서드가 호출될 때 반환할 값 설정
        when(integrationEntryRepository.findAll()).thenReturn(Arrays.asList(entry1, entry2));

        // IntegrationEntryService의 getEntriesByUser 메서드 호출 (null 인자)
        List<IntegrationEntry> entries = integrationEntryService.getEntriesByUser(null);

        // 결과 확인
        assertThat(entries).isNotNull();
        assertThat(entries.size()).isEqualTo(2);//여기서 튕김;
    }
    @Test
    public void testGetAllEntries() {
        // 가짜 IntegrationEntry 데이터 생성
        IntegrationEntry entry1 = new IntegrationEntry();
        entry1.setId(1L);
        entry1.setEventType("Test Event 1");

        IntegrationEntry entry2 = new IntegrationEntry();
        entry2.setId(2L);
        entry2.setEventType("Test Event 2");


        // IntegrationEntryService의 getAllEntries 메서드 호출
        List<IntegrationEntry> entries = integrationEntryService.getAllEntries();

        // 결과 확인
        assertThat(entries).isNotNull();
        assertThat(entries.size()).isEqualTo(2);
        assertThat(entries.get(0).getEventType()).isEqualTo("Test Event 1");
        assertThat(entries.get(1).getEventType()).isEqualTo("Test Event 2");
    }
}
