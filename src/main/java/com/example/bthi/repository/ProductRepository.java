package com.example.bthi.repository;

import com.example.bthi.entitty.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByNameContainingOrAddressContaining(String name, String address);
}
