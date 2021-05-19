package com.esay2excel.crm.repository;

import com.esay2excel.crm.domain.OrderAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAddressRepository extends JpaRepository<OrderAddress,String> {
}
