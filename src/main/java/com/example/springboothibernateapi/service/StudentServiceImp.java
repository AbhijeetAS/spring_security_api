package com.example.springboothibernateapi.service;

import com.example.springboothibernateapi.dao.StudentDao;
import com.example.springboothibernateapi.model.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Transactional
    @Override
    public List<Student> get() {
        return studentDao.get();
    }

    @Transactional
    @Override
    public List<Student> get(String StudentDepartment) {
        return studentDao.get(StudentDepartment);
    }

    @Override
    public List<Student> get(String StudentDepartment, int Cgpa) {
        return studentDao.get(StudentDepartment,Cgpa);
    }

    @Transactional
    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Transactional
    @Override
    public void delete(int StudentId) {
         studentDao.delete(StudentId);
    }
}
