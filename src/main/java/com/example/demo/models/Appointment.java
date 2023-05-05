package com.example.demo.models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name="appointment")
 public class Appointment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false,length = 11)
        private Integer id;
        @Column(nullable = false)
        private String location;
        @Column(nullable = false)
        private String destination;

        @Column(nullable = false)
        private Integer ticket_price;
        @Column(nullable = false)
        private String day;

        @Column(nullable = false)
        private String time;

        @Column(nullable = false)
        private Integer max_travelers;

        public Appointment(String location, String destination, Integer ticket_price, String day, String time, Integer max_travelers) {
            this.location = location;
            this.destination = destination;
            this.ticket_price = ticket_price;
            this.day = day;
            this.time = time;
            this.max_travelers = max_travelers;
        }
    }


