package com.windowsxp.opportunet_hackaton.controller.vacancies;

import com.windowsxp.opportunet_hackaton.dto.vacancy.VacancyCreateRequestDTO;
import com.windowsxp.opportunet_hackaton.dto.vacancy.VacancyCreateResponseDTO;
import com.windowsxp.opportunet_hackaton.dto.vacancy.VacancyGetDTO;
import com.windowsxp.opportunet_hackaton.entities.StudentVacancyRequest;
import com.windowsxp.opportunet_hackaton.entities.enums.EmploymentType;
import com.windowsxp.opportunet_hackaton.entities.enums.ExperienceType;
import com.windowsxp.opportunet_hackaton.entities.enums.WorkScheduleType;
import com.windowsxp.opportunet_hackaton.exception.UserNotFoundException;
import com.windowsxp.opportunet_hackaton.repositories.StudentRepository;
import com.windowsxp.opportunet_hackaton.service.vacancy.VacancyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyService vacancyService;
    private final StudentRepository studentRepository;

    @GetMapping("/create")
    public String createPage(Model model) {
        return "Create_Project";
    }

    @PostMapping("/create")
    public ResponseEntity<VacancyCreateResponseDTO> createVacancy(@Valid @RequestBody VacancyCreateRequestDTO dto) {
        VacancyCreateResponseDTO vacancy = vacancyService.createVacancy(dto);
        return ResponseEntity.ok(vacancy);
    }

    @GetMapping("/{vacancyId}")
    public ResponseEntity<VacancyGetDTO> getVacancy(@PathVariable Long vacancyId) {
        VacancyGetDTO vacancyGetDTO = vacancyService.getVacancy(vacancyId);
        return ResponseEntity.ok(vacancyGetDTO);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<List<VacancyGetDTO>> getVacanciesByCompany(@PathVariable Long companyId) {
        List<VacancyGetDTO> vacancyGetDTOs = vacancyService.getVacancies(companyId);
        return ResponseEntity.ok(vacancyGetDTOs);
    }

    @GetMapping
    public ResponseEntity<List<VacancyGetDTO>> getVacancies() {
        List<VacancyGetDTO> vacancyGetDTOs = vacancyService.getVacancies();
        return ResponseEntity.ok(vacancyGetDTOs);
    }

    @PostMapping("/{vacancyId}/apply")
    public ResponseEntity<StudentVacancyRequest> applyToVacancy(
            @PathVariable Long vacancyId,
            @RequestParam(value = "coverLetter", required = false) String coverLetter) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Long studentId = studentRepository.findByEmail(email).orElseThrow(UserNotFoundException::new).getId();

        StudentVacancyRequest request = vacancyService.applyToVacancy(studentId, vacancyId, coverLetter);

        return ResponseEntity.ok(request);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<VacancyGetDTO>> getVacanciesByFilter(
            @RequestParam(value = "location", required = false) String location,
            @RequestParam(value = "minSalary", required = false) Float minSalary,
            @RequestParam(value = "maxSalary", required = false) Float maxSalary,
            @RequestParam(value = "experienceType", required = false) ExperienceType experienceType,
            @RequestParam(value = "employmentType", required = false) EmploymentType employmentType,
            @RequestParam(value = "workScheduleType", required = false) WorkScheduleType workScheduleType) {

        List<VacancyGetDTO> vacancies = vacancyService.getVacanciesByFilter(
                location, minSalary, maxSalary, experienceType, employmentType, workScheduleType);
        return ResponseEntity.ok(vacancies);
    }
}
