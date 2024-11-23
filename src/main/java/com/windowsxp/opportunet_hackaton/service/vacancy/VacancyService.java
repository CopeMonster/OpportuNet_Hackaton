package com.windowsxp.opportunet_hackaton.service.vacancy;

import com.windowsxp.opportunet_hackaton.dto.vacancy.VacancyCreateRequestDTO;
import com.windowsxp.opportunet_hackaton.dto.vacancy.VacancyCreateResponseDTO;
import com.windowsxp.opportunet_hackaton.dto.vacancy.VacancyGetDTO;
import com.windowsxp.opportunet_hackaton.entities.Company;
import com.windowsxp.opportunet_hackaton.entities.Vacancy;
import com.windowsxp.opportunet_hackaton.exception.CompanyNotFoundException;
import com.windowsxp.opportunet_hackaton.exception.VacancyNotFoundException;
import com.windowsxp.opportunet_hackaton.repositories.CompanyRepository;
import com.windowsxp.opportunet_hackaton.repositories.VacancyRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VacancyService {
    private final VacancyRepository vacancyRepository;
    private final CompanyRepository companyRepository;

    @Transactional
    public VacancyCreateResponseDTO createVacancy(Long companyId, @Valid VacancyCreateRequestDTO dto) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);

        Vacancy vacancy = Vacancy.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .requirements(dto.getRequirement())
                .location(dto.getLocation())
                .experienceType(dto.getExperienceType())
                .employmentType(dto.getEmploymentType())
                .workScheduleType(dto.getWorkScheduleType())
                .salary(dto.getSalary())
                .company(company)
                .build();

        vacancyRepository.save(vacancy);

        return VacancyCreateResponseDTO.builder()
                .vacancyId(vacancy.getId())
                .title(vacancy.getTitle())
                .description(vacancy.getDescription())
                .requirement(vacancy.getRequirements())
                .location(vacancy.getLocation())
                .experienceType(vacancy.getExperienceType())
                .employmentType(vacancy.getEmploymentType())
                .workScheduleType(vacancy.getWorkScheduleType())
                .salary(vacancy.getSalary())
                .company(vacancy.getCompany())
                .build();
    }

    @Transactional
    public VacancyGetDTO getVacancy(Long vacancyId) {
        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(VacancyNotFoundException::new);

        return VacancyGetDTO.builder()
                .title(vacancy.getTitle())
                .description(vacancy.getDescription())
                .requirement(vacancy.getRequirements())
                .location(vacancy.getLocation())
                .experienceType(vacancy.getExperienceType())
                .employmentType(vacancy.getEmploymentType())
                .workScheduleType(vacancy.getWorkScheduleType())
                .salary(vacancy.getSalary())
                .company(vacancy.getCompany())
                .build();
    }

    @Transactional
    public List<VacancyGetDTO> getVacancies(Long companyId) {
        List<Vacancy> vacancies = vacancyRepository.findAll()
                .stream()
                .filter(vacancy -> Objects.equals(vacancy.getCompany().getId(), companyId))
                .toList();

        return vacancies.stream().map(vacancy -> VacancyGetDTO.builder()
                        .title(vacancy.getTitle())
                        .description(vacancy.getDescription())
                        .requirement(vacancy.getRequirements())
                        .location(vacancy.getLocation())
                        .experienceType(vacancy.getExperienceType())
                        .employmentType(vacancy.getEmploymentType())
                        .workScheduleType(vacancy.getWorkScheduleType())
                        .salary(vacancy.getSalary())
                        .company(vacancy.getCompany())
                        .build())
                .toList();
    }
}
