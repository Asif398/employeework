package com.asif.service;

import com.asif.entity.Employee;
import com.asif.exception.ResourceNotFound;
import com.asif.payload.EmployeeDto;
import com.asif.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

//    public EmployeeDto addEmployee(EmployeeDto dto) {
//        Employee employee = mapToEntity(dto);
//        Employee emp = employeeRepository.save(employee);
//        EmployeeDto employeeDto = mapToDto(emp);
//
//        return  employeeDto;
//    }
//


    public EmployeeDto addEmployee(EmployeeDto dto) {

        Employee employee = mapToEntity(dto);

        Employee emp = employeeRepository.save(employee);
        EmployeeDto employeeDto = mapToDto(emp);

        return employeeDto;
    }


    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {

        Employee employee = mapToEntity(dto);
        employee.setId(id);
        Employee updateEmployee = employeeRepository.save(employee);
        EmployeeDto employeeDto = mapToDto(updateEmployee);
        return employeeDto;
    }

//    public List<EmployeeDto> getEmployee() {
//        List<Employee> employees = employeeRepository.findAll();
//        List<EmployeeDto> dto = employees.stream().map(e -> mapToDto(e)).collect(Collectors.toList());
//        return dto;
//    }

    public List<EmployeeDto> getEmployee(int pageNo, int pageSize, String sortBy, String sortDir) {
        //convert String to sort object of(take int, take int, take sort object)
        //convert String to Object use Sort.by() method
        //sort by Ascending and Descending order sort object can be Ascending &sort object can be Descending
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable page = PageRequest.of(pageNo, pageSize, sort);
        Page<Employee> all = employeeRepository.findAll(page);
//        all page Employee convert to Lisst use getContent()
        List<Employee> employees = all.getContent();
        List<EmployeeDto> dto = employees.stream().map(e -> mapToDto(e)).collect(Collectors.toList());
        return dto;
    }

    public EmployeeDto getEmployeeById(Long empId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(
                () -> new ResourceNotFound("Record not found with id " + empId)
        );
        EmployeeDto dto = mapToDto(employee);
        return dto;

    }


    EmployeeDto mapToDto(Employee employee) {
        EmployeeDto dto = modelMapper.map(employee, EmployeeDto.class);

        return dto;
    }

    Employee mapToEntity(EmployeeDto dto) {
        Employee emp = modelMapper.map(dto, Employee.class);
        return emp;


    }


}