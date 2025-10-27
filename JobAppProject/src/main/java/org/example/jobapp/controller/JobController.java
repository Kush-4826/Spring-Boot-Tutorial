package org.example.jobapp.controller;

import org.example.jobapp.model.JobPost;
import org.example.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping({"/", "home"})
    public String index(){
        return "home";
    }

    @RequestMapping("addjob")
    public String addJob(){
        return "addjob";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model model){
        List<JobPost> jobPosts = this.jobService.getJobs();
        model.addAttribute("jobPosts", jobPosts);
        return "viewalljobs";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost) {
        this.jobService.addJob(jobPost);
        return "success";
    }
}
