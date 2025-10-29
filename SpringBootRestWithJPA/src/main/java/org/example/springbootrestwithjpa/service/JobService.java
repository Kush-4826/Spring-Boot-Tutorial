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
}
