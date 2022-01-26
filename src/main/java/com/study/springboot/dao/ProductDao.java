package com.study.springboot.dao;

import com.study.springboot.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    List<Product> findByIdGreaterThan(int id);
}

