package org.example.springbootrest.repo;

import org.example.springbootrest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepository {
    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost("1", "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                    List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

            new JobPost("2", "Frontend Developer", "Experience in building responsive web applications using React", 3,
                    List.of("HTML", "CSS", "JavaScript", "React")),

            new JobPost("3", "Data Scientist", "Strong background in machine learning and data analysis", 4,
                    List.of("Python", "Machine Learning", "Data Analysis")),

            new JobPost("4", "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                    List.of("Networking", "Cisco", "Routing", "Switching")),

            new JobPost("5", "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                    List.of("iOS Development", "Android Development", "Mobile App"))
    ));


    public List<JobPost> getJobs() {
        return this.jobs;
    }

    public void addJob(JobPost jobPost) {
        this.jobs.add(jobPost);
    }

    public JobPost getJobById(String id) {
        for(JobPost job : this.jobs) {
            if(job.getPostId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    public void updateJob(JobPost job) {
        for(JobPost jobPost : this.jobs) {
            if(jobPost.getPostId().equals(job.getPostId())) {
                jobPost.setPostProfile(job.getPostProfile());
                jobPost.setPostDesc(job.getPostDesc());
                jobPost.setPostTechStack(job.getPostTechStack());
                jobPost.setReqExperience(job.getReqExperience());
            }
        }
    }

    public void deleteJob(String id) {
        JobPost post = getJobById(id);
        this.jobs.remove(post);
    }
}
