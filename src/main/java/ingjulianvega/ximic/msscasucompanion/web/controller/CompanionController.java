package ingjulianvega.ximic.msscasucompanion.web.controller;


import ingjulianvega.ximic.msscasucompanion.services.CompanionService;
import ingjulianvega.ximic.msscasucompanion.web.model.Companion;
import ingjulianvega.ximic.msscasucompanion.web.model.CompanionDto;
import ingjulianvega.ximic.msscasucompanion.web.model.CompanionList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CompanionController implements CompanionI {

    private final CompanionService companionService;

    @Override
    public ResponseEntity<CompanionList> get() {
        return new ResponseEntity<>(companionService.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CompanionDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(companionService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid Companion companion) {
        companionService.create(companion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid Companion companion) {
        companionService.updateById(id, companion);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        companionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
