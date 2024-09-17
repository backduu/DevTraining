package com.toyproject.devtraining.controller;

import com.toyproject.devtraining.dto.DeveloperDTO;
import com.toyproject.devtraining.entity.CreateDeveloper;
import com.toyproject.devtraining.service.DevTrainingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HomeController {
    private final DevTrainingService devTrainingService;

    @GetMapping(value = "/countDeveloper")
    public int countDeveloper() {
        return devTrainingService.getDeveloperCount();
    }

    @PostMapping(value="/create-developer")
    public CreateDeveloper.Response createDevelopers(
        @Valid @RequestBody CreateDeveloper.Request request
    ) {
        log.info("request : {}", request);

        return devTrainingService.createDevelopers(request);
    }
    // ---- 개발자 단건 조회
    @GetMapping(value ="/developer/detail/{memberId}")
    public ResponseEntity<DeveloperDTO> getDeveloperDetail(
            @PathVariable String memberId
    ) {
        return ResponseEntity.ok(devTrainingService.getDeveloperDetail());
    }

    // ---- 개발자 다건 조회
    @GetMapping(value="/getDevelopers")
    public ResponseEntity<List<DeveloperDTO>> getDevelopers() {
        return ResponseEntity.ok(devTrainingService.getDevelopers());
    }

}