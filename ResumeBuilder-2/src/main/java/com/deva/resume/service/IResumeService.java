package com.deva.resume.service;

import java.util.List;
import java.util.Optional;

import com.deva.resume.model.Resume;

public interface IResumeService {
 Integer saveResume(Resume r);
 Optional<Resume> getOneResume(Integer id);
 List<Resume> getAllResume();
}
