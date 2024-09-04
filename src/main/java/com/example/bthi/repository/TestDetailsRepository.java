package com.example.bthi.repository;

import com.example.bthi.entitty.TestDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDetailsRepository extends CrudRepository<TestDetail, Integer> {
    List<TestDetail> findByPointObtainedGreaterThanEqual(Double pointObtained);
}
