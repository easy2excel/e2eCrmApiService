package com.esay2excel.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "order_note_link")
public class OrderNoteLink {

    @Id
    @GenericGenerator(name = "id", strategy = "com.esay2excel.crm.generator.OrderNoteLinkGenerator")
    @GeneratedValue(generator = "id")

    @Column(name = "order_note_id")
    private String id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "note_id")
    private String noteId;

}
