package com.simplilearn.sporty.shoes.repository;

import com.simplilearn.sporty.shoes.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

//	List<Order> findByEmail(String email);
}
