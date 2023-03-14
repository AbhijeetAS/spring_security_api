package com.example.springboothibernateapi.dao;

import com.example.springboothibernateapi.model.Student;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImp implements StudentDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> get() {

        Session currentSession=entityManager.unwrap(Session.class);
        Query query=currentSession.createQuery("from Student", Student.class);
         List<Student> list=query.getResultList();
         return  list;
    }

    @Override
    public List<Student> get(String StudentDepartment) {
        Session currentSession=entityManager.unwrap(Session.class);
        Query query=currentSession.createQuery("from Student where StudentDepartment=:StudentDepartment", Student.class);
        query.setParameter("StudentDepartment",StudentDepartment);
        List<Student> list=query.getResultList();
        return list;
    }

    @Override
    public List<Student> get(String StudentDepartment, int Cgpa) {
        Session currentSession=entityManager.unwrap(Session.class);
        Query  query=currentSession.createQuery("from Student where StudentDepartment=:StudentDepartment and StudentCgpa>:Cgpa", Student.class);
        query.setParameter("StudentDepartment",StudentDepartment);
        query.setParameter("Cgpa",Cgpa);
        List<Student> list=query.getResultList();
        return list;
    }

    @Override
    public void save(Student student) {

        Session currentSession=entityManager.unwrap(Session.class);
        currentSession.save(student);

    }

    @Override
    public void delete(int StudentId) {

        Session currentSession=entityManager.unwrap(Session.class);
        Student student=currentSession.get(Student.class,StudentId);
        currentSession.delete(student);

    }
}
