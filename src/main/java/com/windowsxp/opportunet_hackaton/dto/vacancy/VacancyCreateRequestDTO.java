package com.windowsxp.opportunet_hackaton.dto.vacancy;

import com.windowsxp.opportunet_hackaton.entities.enums.EmploymentType;
import com.windowsxp.opportunet_hackaton.entities.enums.ExperienceType;
import com.windowsxp.opportunet_hackaton.entities.enums.WorkScheduleType;
import lombok.Data;

@Data
public class VacancyCreateRequestDTO {
    private String title;
    private String description;
    private String requirement;
    private String location;
    private ExperienceType experienceType;
    private EmploymentType employmentType;
    private WorkScheduleType workScheduleType;
    private float salary;
}
