package ingjulianvega.ximic.msscasucompanion.services;


import ingjulianvega.ximic.msscasucompanion.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasucompanion.domain.CompanionEntity;
import ingjulianvega.ximic.msscasucompanion.domain.repositories.CompanionRepository;
import ingjulianvega.ximic.msscasucompanion.exception.CompanionException;
import ingjulianvega.ximic.msscasucompanion.web.Mappers.CompanionMapper;
import ingjulianvega.ximic.msscasucompanion.web.model.Companion;
import ingjulianvega.ximic.msscasucompanion.web.model.CompanionDto;
import ingjulianvega.ximic.msscasucompanion.web.model.CompanionList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class CompanionServiceImpl implements CompanionService {

    private final CompanionRepository companionRepository;
    private final CompanionMapper companionMapper;

    @Cacheable(cacheNames = "companionListCache")
    @Override
    public CompanionList get() {
        log.debug("get()...");
        return CompanionList
                .builder()
                .companionDtoList(companionMapper.companionEntityListToCompanionDtoList(companionRepository.findAll()))
                .build();
    }

    @Cacheable(cacheNames = "companionCache")
    @Override
    public CompanionDto getById(UUID id) {
        log.debug("getById()...");
        return companionMapper.companionEntityToCompanionDto(
                companionRepository.findById(id)
                        .orElseThrow(() -> new CompanionException(ErrorCodeMessages.COMPANION_NOT_FOUND, "")));
    }

    @Override
    public void create(Companion companion) {
        log.debug("create()...");
        companionMapper.companionEntityToCompanionDto(
                companionRepository.save(
                        companionMapper.companionDtoToCompanionEntity(
                                CompanionDto
                                        .builder()
                                        .documentTypeId(companion.getDocumentTypeId())
                                        .name(companion.getName())
                                        .firstLastName(companion.getFirstLastName())
                                        .secondLastName(companion.getSecondLastName())
                                        .homePhone(companion.getHomePhone())
                                        .mobilePhone(companion.getMobilePhone())
                                        .email(companion.getEmail())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, Companion companion) {
        log.debug("updateById...");
        CompanionEntity companionEntity = companionRepository.findById(id)
                .orElseThrow(() -> new CompanionException(ErrorCodeMessages.COMPANION_NOT_FOUND, ""));

        companionEntity.setDocumentTypeId(companion.getDocumentTypeId());
        companionEntity.setName(companion.getName());
        companionEntity.setFirstLastName(companion.getFirstLastName());
        companionEntity.setSecondLastName(companion.getSecondLastName());
        companionEntity.setHomePhone(companion.getHomePhone());
        companionEntity.setMobilePhone(companion.getMobilePhone());
        companionEntity.setEmail(companion.getEmail());

        companionRepository.save(companionEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        companionRepository.deleteById(id);
    }
}
