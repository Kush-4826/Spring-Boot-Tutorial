package org.example.springbootrestwithjpa;

import org.example.springbootrestwithjpa.model.JobPost;
import org.example.springbootrestwithjpa.repo.JobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootRestApplication {
    private final JobRepository jobRepository;

    public SpringBootRestApplication(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            if(this.jobRepository.count() == 0) {
                System.out.println("Seeding Database...");
                List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                        new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

                        new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                                List.of("HTML", "CSS", "JavaScript", "React")),

                        new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                                List.of("Python", "Machine Learning", "Data Analysis")),

                        new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                                List.of("Networking", "Cisco", "Routing", "Switching")),

                        new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                                List.of("iOS Development", "Android Development", "Mobile App"))
                ));
                this.jobRepository.saveAll(jobs);
            }
        };
    }
}
