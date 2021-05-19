package com.esay2excel.crm.repository;


import com.esay2excel.crm.domain.OrderInvoiceLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInvoiceLinkRepository extends JpaRepository<OrderInvoiceLink, String> {

}
