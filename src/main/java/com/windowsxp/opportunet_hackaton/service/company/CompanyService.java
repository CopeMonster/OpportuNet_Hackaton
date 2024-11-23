package com.windowsxp.opportunet_hackaton.service.company;

import com.windowsxp.opportunet_hackaton.dto.auth.company.CompanyDTO;
import com.windowsxp.opportunet_hackaton.entities.Company;
import com.windowsxp.opportunet_hackaton.exception.CompanyNotFoundException;
import com.windowsxp.opportunet_hackaton.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyDTO getCompanyById(Long companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(CompanyNotFoundException::new);

        return CompanyDTO.from(company);
    }

    public List<CompanyDTO> getCompanies() {
        List<Company> companies = companyRepository.findAll();

        return companies.stream().map(CompanyDTO::from).toList();
    }
}
