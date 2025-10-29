package org.example.springbootrestwithjpa.service;

import org.example.springbootrestwithjpa.model.JobPost;
import org.example.springbootrestwithjpa.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void addJob(JobPost jobPost) {
        this.jobRepository.addJob(jobPost);
    }

    public List<JobPost> getJobs() {
        return this.jobRepository.getJobs();
    }

    public JobPost getJobById(String id) {
        return this.jobRepository.getJobById(id);
    }

    public void updateJob(JobPost job) {
        this.jobRepository.updateJob(job);
    }

    public void deleteJob(String id) {
        this.jobRepository.deleteJob(id);
    }
}
