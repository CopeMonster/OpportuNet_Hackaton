package com.windowsxp.opportunet_hackaton.dto.vacancy;

import com.windowsxp.opportunet_hackaton.entities.Vacancy;
import com.windowsxp.opportunet_hackaton.entities.enums.EmploymentType;
import com.windowsxp.opportunet_hackaton.entities.enums.ExperienceType;
import com.windowsxp.opportunet_hackaton.entities.enums.WorkScheduleType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VacancyDTO {
    private String title;
    private String description;
    private String requirements;
    private String location;
    private ExperienceType experienceType;
    private EmploymentType employmentType;
    private WorkScheduleType workScheduleType;
    private float salary;

    public static VacancyDTO from(Vacancy vacancy) {
        return VacancyDTO.builder()
                .title(vacancy.getTitle())
                .description(vacancy.getDescription())
                .requirements(vacancy.getRequirements())
                .location(vacancy.getLocation())
                .experienceType(vacancy.getExperienceType())
                .employmentType(vacancy.getEmploymentType())
                .workScheduleType(vacancy.getWorkScheduleType())
                .salary(vacancy.getSalary())
                .build();
    }
}
