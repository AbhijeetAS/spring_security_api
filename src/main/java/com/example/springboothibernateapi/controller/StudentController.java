package com.example.springboothibernateapi.controller;

import com.example.springboothibernateapi.model.Student;
import com.example.springboothibernateapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    @PreAuthorize("hasAuthority('ROLE_TEACHER')")
    public List<Student> get()
    {
        return studentService.get();
    }



    @GetMapping("/department/{department}")
    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    public List<Student> get(@PathVariable("department") String StudentDepartment)
    {
        return studentService.get(StudentDepartment);
    }

    @GetMapping("department/{department}/cgpa/{cgpa}")
    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    public List<Student> get(@PathVariable("department") String StudentDepartment, @PathVariable("cgpa") int cgpa)
    {
        return studentService.get(StudentDepartment,cgpa);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_TEACHER')")
    public String delete(@PathVariable int id)
    {
        studentService.delete(id);
        return "delete successfully";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_TEACHER')")
    public Student save(@RequestBody Student studentObj)
    {
        System.out.println(studentObj);
        studentService.save(studentObj);
        return  studentObj;

    }


}
