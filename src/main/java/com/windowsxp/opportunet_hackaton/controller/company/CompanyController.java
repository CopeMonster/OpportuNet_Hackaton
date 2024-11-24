package com.windowsxp.opportunet_hackaton.controller.company;

import com.windowsxp.opportunet_hackaton.dto.auth.company.CompanyDTO;
import com.windowsxp.opportunet_hackaton.dto.auth.student.StudentDTO;
import com.windowsxp.opportunet_hackaton.repositories.CompanyRepository;
import com.windowsxp.opportunet_hackaton.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;


    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long companyId) {
        CompanyDTO companyDTO = companyService.getCompanyById(companyId);

        return ResponseEntity.ok(companyDTO);
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getCompanies() {
        List<CompanyDTO> companyDTOS = companyService.getCompanies();

        return ResponseEntity.ok(companyDTOS);
    }
}
