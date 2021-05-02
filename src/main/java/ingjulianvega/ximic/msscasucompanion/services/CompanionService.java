package ingjulianvega.ximic.msscasucompanion.services;


import ingjulianvega.ximic.msscasucompanion.web.model.Companion;
import ingjulianvega.ximic.msscasucompanion.web.model.CompanionDto;
import ingjulianvega.ximic.msscasucompanion.web.model.CompanionList;

import java.util.UUID;

public interface CompanionService {
    CompanionList get();

    CompanionDto getById(UUID id);

    void create(Companion companion);

    void updateById(UUID id, Companion companion);

    void deleteById(UUID id);


}
