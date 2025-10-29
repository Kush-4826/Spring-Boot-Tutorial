package org.example.springbootrestwithjpa.repo;

import org.example.springbootrestwithjpa.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository  extends JpaRepository<JobPost, Integer> {

}