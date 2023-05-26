package com.students.Service.Impl;

import com.students.Entity.Student;
import com.students.Payload.StudentDTO;
import com.students.Payload.StudentResponse;
import com.students.Repository.StudentRepository;
import com.students.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponse getFilteredStudents(int pageNo, int pageSize, String sortBy, String sortDir) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.Direction.fromString(sortDir), sortBy);
        Page<Student> students = studentRepository.findAll(pageable);

        List<StudentDTO> studentDTOs;
        studentDTOs = students.getContent().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        StudentResponse response = new StudentResponse();
        response.setContent(studentDTOs);
        response.setPageNo(pageNo);
        response.setPageSize(pageSize);
        response.setTotalElements((int) students.getTotalElements());
        response.setTotalPages(students.getTotalPages());
        response.setLast(students.isLast());

        return response;
    }

    private StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setTotalMarks(student.getTotalMarks());
        return dto;
    }
}
