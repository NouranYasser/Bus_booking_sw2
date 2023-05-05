package com.example.demo.models;

import jakarta.persistence.*;
import com.example.demo.enums.RequestStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name="request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11)
    private Integer ID;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private Double ticket_price;

    @Column(nullable = false)
    private String day;

    @Column(nullable = false)
    private Integer num_of_travelers;

    @Column(nullable = false)
    private String time;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus Status = RequestStatus.Pending;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(nullable = false)
    private User user;

}
