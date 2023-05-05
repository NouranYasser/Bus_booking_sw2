package com.example.demo.services;
import com.example.demo.repositories.AppointmentRepository;
import com.example.demo.models.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private  AppointmentRepository appointmentRepository;
    public List<Appointment>getAllAppointment (){ return appointmentRepository.findAll();}

    public void addAppointment(Appointment newAppointment) {
        appointmentRepository.save(newAppointment);

    }
    public void updateAppointment(Appointment updateAppointment) {
        appointmentRepository.save(updateAppointment);

    }
    public void deleteAppointment(Integer id){
        appointmentRepository.deleteById(id);
    }

}
