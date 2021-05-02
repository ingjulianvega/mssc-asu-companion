package ingjulianvega.ximic.msscasucompanion.domain.repositories;

import ingjulianvega.ximic.msscasucompanion.domain.CompanionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface CompanionRepository extends JpaRepository<CompanionEntity, UUID>, JpaSpecificationExecutor<CompanionEntity> {
}
