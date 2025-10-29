package org.example.springbootrestwithjpa.repo;

import org.example.springbootrestwithjpa.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository  extends JpaRepository<JobPost, Integer> {

    List<JobPost> findJobPostsByPostProfileOrPostDescContains(String postProfile, String postDesc);
}