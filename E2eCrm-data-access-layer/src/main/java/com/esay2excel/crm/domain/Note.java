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
@Table(name = "note")
public class Note {

    @Id
    @GenericGenerator(name = "id", strategy = "com.esay2excel.crm.generator.NoteGenerator")
    @GeneratedValue(generator = "id")

    @Column(name = "note_id")
    private String id;

    @Column(name = "note_type")
    private String noteType;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "description")
    private String description;

    @Column(name = "org_id")
    private String orgId;
}
