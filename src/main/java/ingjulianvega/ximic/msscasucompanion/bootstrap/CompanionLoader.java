package ingjulianvega.ximic.msscasucompanion.bootstrap;

import ingjulianvega.ximic.msscasucompanion.domain.CompanionEntity;
import ingjulianvega.ximic.msscasucompanion.domain.repositories.CompanionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class CompanionLoader implements CommandLineRunner {

    private final CompanionRepository companionRepository;

    @Override
    public void run(String... args) throws Exception {
        if (companionRepository.count() == 0) {
            loadRecommendationObjects();
        }
    }

    private void loadRecommendationObjects() {
        companionRepository.saveAll(Arrays.asList(
                CompanionEntity.builder()
                        .documentTypeId(UUID.randomUUID())
                        .name("companion 1 name")
                        .firstLastName("companion 1 lastname")
                        .secondLastName("companion 1 second lastname")
                        .homePhone("123456789")
                        .mobilePhone("3101234567")
                        .email("companion1@gmail.com")
                        .build(),
                CompanionEntity.builder()
                        .documentTypeId(UUID.randomUUID())
                        .name("companion 2 name")
                        .firstLastName("companion 2 lastname")
                        .secondLastName("companion 2 second lastname")
                        .homePhone("123456789")
                        .mobilePhone("3101234567")
                        .build(),
                CompanionEntity.builder()
                        .documentTypeId(UUID.randomUUID())
                        .name("companion 3 name")
                        .firstLastName("companion 3 lastname")
                        .secondLastName("companion 3 second lastname")
                        .homePhone("123456789")
                        .mobilePhone("3101234567")
                        .email("companion3@gmail.com")
                        .build(),
                CompanionEntity.builder()
                        .documentTypeId(UUID.randomUUID())
                        .name("companion 4 name")
                        .firstLastName("companion 4 lastname")
                        .build(),
                CompanionEntity.builder()
                        .documentTypeId(UUID.randomUUID())
                        .name("companion 5 name")
                        .firstLastName("companion 5 lastname")
                        .secondLastName("companion 5 second lastname")
                        .homePhone("123456789")
                        .mobilePhone("3101234567")
                        .email("companion5@gmail.com")
                        .build()
        ));
    }
}