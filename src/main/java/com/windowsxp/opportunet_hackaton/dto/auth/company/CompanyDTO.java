package com.windowsxp.opportunet_hackaton.dto.auth.company;

import com.windowsxp.opportunet_hackaton.dto.vacancy.VacancyDTO;
import com.windowsxp.opportunet_hackaton.entities.Company;
import com.windowsxp.opportunet_hackaton.entities.Vacancy;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CompanyDTO {
    private String name;
    private String BIN;
    private String description;
    private List<VacancyDTO> vacancyDTOS;

    public static CompanyDTO from(Company company) {
        List<Vacancy> vacancies = company.getVacancies();

        return CompanyDTO.builder()
                .name(company.getName())
                .BIN(company.getBIN())
                .description(company.getDescription())
                .vacancyDTOS(vacancies.stream().map(VacancyDTO::from).toList())
                .build();
    }
}
