package com.example.bthi.repository;

import com.example.bthi.entitty.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findByEmailContainingOrFullNameContaining(String email, String fullName);


}
