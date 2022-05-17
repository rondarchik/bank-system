package com.victoria.app.web.dto.mapper;

import com.victoria.app.core.model.SalaryProjectRequest;
import com.victoria.app.core.service.SalaryProjectService;
import com.victoria.app.web.dto.SalaryProjectRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalaryProjectRequestDtoMapper {

    @Autowired
    private SalaryProjectService salaryProjectService;

    public SalaryProjectRequest mapToSalaryProjectRequest(SalaryProjectRequestDto salaryProjectRequestDto) {
        SalaryProjectRequest salaryProjectRequest = new SalaryProjectRequest();

        salaryProjectRequest.setSalaryProject(salaryProjectService.findById(salaryProjectRequestDto.getSalaryProjectId()));
        salaryProjectRequest.setSalary(salaryProjectRequestDto.getSalary());
        salaryProjectRequest.setClientId(salaryProjectRequestDto.getClientId());

        salaryProjectRequest.setOperatorApproved(salaryProjectRequestDto.isOperatorApproved());
        salaryProjectRequest.setSpecApproved(salaryProjectRequestDto.isSpecApproved());

        return salaryProjectRequest;
    }

    public SalaryProjectRequestDto mapToSalaryProjectRequestDto(SalaryProjectRequest salaryProjectRequest) {
        SalaryProjectRequestDto salaryProjectRequestDto = new SalaryProjectRequestDto();

        salaryProjectRequestDto.setSalaryProjectId(salaryProjectRequest.getSalaryProject().getId());
        salaryProjectRequestDto.setSalary(salaryProjectRequest.getSalary());
        salaryProjectRequestDto.setClientId(salaryProjectRequest.getClientId());

        salaryProjectRequestDto.setOperatorApproved(salaryProjectRequest.isOperatorApproved());
        salaryProjectRequestDto.setSpecApproved(salaryProjectRequest.isSpecApproved());

        return salaryProjectRequestDto;
    }
}
