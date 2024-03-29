package com.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	
	  List<Orders> findByOrderplacedBetween(LocalDate startDate, LocalDate endDate);
      List<Orders> findAll();

}
