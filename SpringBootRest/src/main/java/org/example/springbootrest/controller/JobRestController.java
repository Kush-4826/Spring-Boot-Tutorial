package org.example.springbootrest.controller;

import org.example.springbootrest.model.JobPost;
import org.example.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    private final JobService jobService;

    @Autowired
    public JobRestController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {
        return this.jobService.getJobs();
    }

    @GetMapping("jobPost/{id}")
    public JobPost getJobById(@PathVariable String id) {
        return this.jobService.getJobById(id);
    }
}
