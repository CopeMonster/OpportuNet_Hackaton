package com.windowsxp.opportunet_hackaton.controller.company;

import com.windowsxp.opportunet_hackaton.dto.vacancy.VacancyCreateRequestDTO;
import com.windowsxp.opportunet_hackaton.dto.vacancy.VacancyCreateResponseDTO;
import com.windowsxp.opportunet_hackaton.entities.Vacancy;
import com.windowsxp.opportunet_hackaton.service.vacancy.VacancyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final VacancyService vacancyService;

    @PostMapping("/{companyId}/vacancies")
    public ResponseEntity<VacancyCreateResponseDTO> createVacancy(
            @PathVariable Long companyId, @Valid @RequestBody VacancyCreateRequestDTO dto) {

        Vacancy vacancy = vacancyService.createVacancy(companyId, dto);
        return ResponseEntity.ok(VacancyCreateResponseDTO.builder()
                        .title(vacancy.getTitle())
                        .description(vacancy.getDescription())
                        .build());
    }

    @GetMapping("/{companyId}/vacancies/{vacancyId}")
    public ResponseEntity<String> getVacancy
}
