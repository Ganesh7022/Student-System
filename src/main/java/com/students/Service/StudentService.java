package com.students.Service;

import com.students.Payload.StudentResponse;

public interface StudentService {
    StudentResponse getFilteredStudents(int pageNo, int pageSize, String sortBy, String sortDir);
}
