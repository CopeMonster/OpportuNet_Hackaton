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
    public VacancyCreateResponseDTO createVacancy(@Valid VacancyCreateRequestDTO dto) {
        Company company = companyRepository.findById(dto.getCompanyId())
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

        return VacancyCreateResponseDTO.from(vacancy);
    }

    @Transactional
    public VacancyGetDTO getVacancy(Long vacancyId) {
        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(VacancyNotFoundException::new);

        return VacancyGetDTO.from(vacancy);
    }

    @Transactional
    public List<VacancyGetDTO> getVacancies(Long companyId) {
        List<Vacancy> vacancies = vacancyRepository.findAll()
                .stream()
                .filter(vacancy -> Objects.equals(vacancy.getCompany().getId(), companyId))
                .toList();

        return vacancies.stream().map(VacancyGetDTO::from).toList();
    }

    @Transactional
    public List<VacancyGetDTO> getVacancies() {
        List<Vacancy> vacancies = vacancyRepository.findAll();

        return vacancies.stream().map(VacancyGetDTO::from).toList();
    }
}
