package com.windowsxp.opportunet_hackaton.dto.vacancy;

import com.windowsxp.opportunet_hackaton.entities.Company;
import com.windowsxp.opportunet_hackaton.entities.Vacancy;
import com.windowsxp.opportunet_hackaton.entities.enums.EmploymentType;
import com.windowsxp.opportunet_hackaton.entities.enums.ExperienceType;
import com.windowsxp.opportunet_hackaton.entities.enums.WorkScheduleType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VacancyCreateResponseDTO {
    private Long vacancyId;
    private String title;
    private String description;
    private String requirement;
    private String location;
    private ExperienceType experienceType;
    private EmploymentType employmentType;
    private WorkScheduleType workScheduleType;
    private float salary;
    private Company company;

    public static VacancyCreateResponseDTO from(Vacancy vacancy) {
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
}
