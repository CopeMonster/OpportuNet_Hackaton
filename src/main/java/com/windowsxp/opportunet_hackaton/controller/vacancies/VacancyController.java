package com.windowsxp.opportunet_hackaton.controller.vacancies;

import com.windowsxp.opportunet_hackaton.dto.vacancy.VacancyCreateRequestDTO;
import com.windowsxp.opportunet_hackaton.dto.vacancy.VacancyCreateResponseDTO;
import com.windowsxp.opportunet_hackaton.dto.vacancy.VacancyGetDTO;
import com.windowsxp.opportunet_hackaton.service.vacancy.VacancyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyService vacancyService;

    @PostMapping
    public ResponseEntity<VacancyCreateResponseDTO> createVacancy(@Valid @RequestBody VacancyCreateRequestDTO dto) {
        VacancyCreateResponseDTO vacancy = vacancyService.createVacancy(dto);
        return ResponseEntity.ok(vacancy);
    }

    @GetMapping("/{vacancyId}")
    public ResponseEntity<VacancyGetDTO> getVacancy(@PathVariable Long vacancyId) {
        VacancyGetDTO vacancyGetDTO = vacancyService.getVacancy(vacancyId);
        return ResponseEntity.ok(vacancyGetDTO);
    }

    @GetMapping
    public ResponseEntity<List<VacancyGetDTO>> getVacanciesByCompany(@RequestBody Long companyId) {
        List<VacancyGetDTO> vacancyGetDTOs = vacancyService.getVacancies(companyId);
        return ResponseEntity.ok(vacancyGetDTOs);
    }

    @GetMapping
    public ResponseEntity<List<VacancyGetDTO>> getVacancies() {
        List<VacancyGetDTO> vacancyGetDTOs = vacancyService.getVacancies();
        return ResponseEntity.ok(vacancyGetDTOs);
    }
}
