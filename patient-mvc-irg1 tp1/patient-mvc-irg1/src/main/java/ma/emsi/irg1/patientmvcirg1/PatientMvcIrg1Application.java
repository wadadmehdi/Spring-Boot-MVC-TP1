package ma.emsi.irg1.patientmvcirg1;


import ma.emsi.irg1.patientmvcirg1.entities.Patient;
import ma.emsi.irg1.patientmvcirg1.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientMvcIrg1Application {

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcIrg1Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(
                    new Patient(null,"Hamid",new Date(),false,143));
            patientRepository.save(
                    new Patient(null,"Mohamded",new Date(),true,313));
            patientRepository.save(
                    new Patient(null,"Amal",new Date(),false,113));
            patientRepository.save(
                    new Patient(null,"Yassmin",new Date(),true,513));

            patientRepository.findAll().forEach(patient -> {
                System.out.println(patient.getNom());
            });
        };
    }

}
