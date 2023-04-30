package com.simplilearn.sporty.shoes.repository;

import com.simplilearn.sporty.shoes.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

	List<Orders> findByEmailid(String email);
}
