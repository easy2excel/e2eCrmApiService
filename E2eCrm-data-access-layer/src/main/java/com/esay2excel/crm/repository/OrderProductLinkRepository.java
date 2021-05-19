package com.esay2excel.crm.repository;

import com.esay2excel.crm.domain.OrderProductLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductLinkRepository extends JpaRepository<OrderProductLink, String> {

}
