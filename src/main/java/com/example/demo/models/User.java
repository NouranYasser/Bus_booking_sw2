package com.example.demo.models;

import com.example.demo.enums.Status;
import com.example.demo.enums.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11)
    private Integer id;


    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String Phone;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.Inactive;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type= Type.Traveler;


    public User(String username, String email, String password, String phone, Type type, Status status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.Phone = phone;
        this.type = type;
        this.status = status;

    }


}
