package com.deva.resume.repo;

import com.deva.resume.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepo extends JpaRepository<Resume, Integer>{

}
