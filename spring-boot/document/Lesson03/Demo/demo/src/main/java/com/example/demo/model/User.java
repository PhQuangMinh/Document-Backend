package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "student_id")
    private String studentID;

    @Column(name = "gender")
    private String gender;

    @Column(name = "zodiac")
    private String zodiac;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "class_name")
    private String className;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hometown")
    private String hometown;

    @Column(name = "email")
    private String email;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "updated_time")
    private Timestamp updateTime;
}
