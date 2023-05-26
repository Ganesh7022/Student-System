package com.students.Controller;


import com.students.Payload.StudentResponse;
import com.students.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //http://localhost:8080/students?pageNo=0&pageSize=4&sortBy=id&sortDir=asc
    @GetMapping
    public StudentResponse getAllPosts(
            @RequestParam(value = "pageNo",defaultValue = "0",required = false)int pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir

    ){
        return  studentService.getFilteredStudents(pageNo,pageSize,sortBy,sortDir);


    }
}
