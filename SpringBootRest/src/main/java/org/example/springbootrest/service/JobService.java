package org.example.springbootrest.service;

import org.example.springbootrest.model.JobPost;
import org.example.springbootrest.repo.JobRepository;
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
}
