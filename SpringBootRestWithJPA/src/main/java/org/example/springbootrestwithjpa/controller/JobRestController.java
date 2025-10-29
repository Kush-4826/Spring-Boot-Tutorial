package org.example.springbootrestwithjpa.controller;

import org.example.springbootrestwithjpa.model.JobPost;
import org.example.springbootrestwithjpa.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "${client.url}")
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
    public JobPost getJobById(@PathVariable int id) {
        return this.jobService.getJobById(id);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost job) {
        this.jobService.addJob(job);
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost job) {
        this.jobService.updateJob(job);
        return this.jobService.getJobById(job.getPostId());
    }

    @DeleteMapping("jobPost/{id}")
    public void deleteJobById(@PathVariable int id) {
        this.jobService.deleteJob(id);
    }

    @GetMapping("jobPosts/search")
    public List<JobPost> searchJob(@RequestParam String q) {
        return this.jobService.searchByKeyword(q);
    }
}
