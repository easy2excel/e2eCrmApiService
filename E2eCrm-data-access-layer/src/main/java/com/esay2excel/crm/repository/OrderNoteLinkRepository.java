package com.esay2excel.crm.repository;

import com.esay2excel.crm.domain.OrderNoteLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderNoteLinkRepository extends JpaRepository<OrderNoteLink, String>{

}
