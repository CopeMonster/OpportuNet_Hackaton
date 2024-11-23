package com.windowsxp.opportunet_hackaton.controller.company;

import com.windowsxp.opportunet_hackaton.dto.vacancy.VacancyCreateRequestDTO;
import com.windowsxp.opportunet_hackaton.dto.vacancy.VacancyCreateResponseDTO;
import com.windowsxp.opportunet_hackaton.dto.vacancy.VacancyGetDTO;
import com.windowsxp.opportunet_hackaton.entities.Vacancy;
import com.windowsxp.opportunet_hackaton.service.vacancy.VacancyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final VacancyService vacancyService;

    @PostMapping("/{companyId}/vacancies")
    public ResponseEntity<VacancyCreateResponseDTO> createVacancy(
            @PathVariable Long companyId, @Valid @RequestBody VacancyCreateRequestDTO dto) {

        VacancyCreateResponseDTO vacancy = vacancyService.createVacancy(companyId, dto);
        return ResponseEntity.ok(vacancy);
    }

    @GetMapping("/{companyId}/vacancies/{vacancyId}")
    public ResponseEntity<VacancyGetDTO> getVacancy(@PathVariable Long companyId, @PathVariable Long vacancyId) {
        VacancyGetDTO vacancyGetDTO = vacancyService.getVacancy(vacancyId);
        return ResponseEntity.ok(vacancyGetDTO);
    }

    @GetMapping("/{companyId}/vacancies")
    public ResponseEntity<List<VacancyGetDTO>> getVacancies(@PathVariable Long companyId) {
        List<VacancyGetDTO> vacancyGetDTOs = vacancyService.getVacancies(companyId);
        return ResponseEntity.ok(vacancyGetDTOs);
    }
}
