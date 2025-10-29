package org.example.springbootrestwithjpa.service;

import org.example.springbootrestwithjpa.model.JobPost;
import org.example.springbootrestwithjpa.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void addJob(JobPost jobPost) {
        this.jobRepository.save(jobPost);
    }

    public List<JobPost> getJobs() {
        return this.jobRepository.findAll();
    }

    public JobPost getJobById(int id) {
        return this.jobRepository.findById(id).orElse(null);
    }

    public void updateJob(JobPost job) {
        this.jobRepository.save(job);
    }

    public void deleteJob(int id) {
        this.jobRepository.deleteById(id);
    }

    public void load() {
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
}
