package com.esay2excel.crm.repository;


import com.esay2excel.crm.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String>{

}
