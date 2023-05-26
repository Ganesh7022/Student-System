package com.students.Payload;

import lombok.Data;

import java.util.List;

@Data
public class StudentResponse {
    private List<StudentDTO> content;
    private int pageNo;
    private int pageSize;
    private int totalElements;
    private int totalPages;
    private boolean isLast;

}
