package ingjulianvega.ximic.msscasucompanion.web.Mappers;


import ingjulianvega.ximic.msscasucompanion.domain.CompanionEntity;
import ingjulianvega.ximic.msscasucompanion.web.model.CompanionDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface CompanionMapper {
    CompanionDto companionEntityToCompanionDto(CompanionEntity recommendationEntity);

    CompanionEntity companionDtoToCompanionEntity(CompanionDto recommendationDto);

    ArrayList<CompanionDto> companionEntityListToCompanionDtoList(List<CompanionEntity> recommendationEntityList);
}
