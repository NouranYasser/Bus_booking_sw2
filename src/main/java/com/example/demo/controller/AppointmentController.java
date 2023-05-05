package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.AppointmentService;
import com.example.demo.models.Appointment;

import java.util.List;
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/getAllAppointments")
    public List <Appointment> getAllAppointments(){return appointmentService.getAllAppointment();}

    @PostMapping("/createappointment")
    public String addAppointment (@RequestBody Appointment newAppointment) {
        appointmentService.addAppointment(newAppointment);
        return "Add Appointment Successfully";
    }
    @PutMapping("/UpdateAppointment")
    public String updateAppointment (@RequestBody Appointment updateAppointment) {
        appointmentService.updateAppointment(updateAppointment);
        return "Update Appointment Successfully";
    }
    @DeleteMapping("/DeleteAppointment")
    public String deleteAppointment (@RequestParam Integer id) {
        appointmentService.deleteAppointment(id);
        return "delete Appointment Successfully";
    }
}
