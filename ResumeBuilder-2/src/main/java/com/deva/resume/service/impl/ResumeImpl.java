package com.deva.resume.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deva.resume.model.Resume;
import com.deva.resume.repo.ResumeRepo;
import com.deva.resume.service.IResumeService;

@Service
public class ResumeImpl implements IResumeService{
	@Autowired
	private ResumeRepo repo;
	
	@Override
	public Integer saveResume(Resume r) {
	r= repo.save(r);
	Integer id = r.getId();
		return id;
	}

	@Override
	public Optional<Resume> getOneResume(Integer id) {
		Optional<Resume> opt = repo.findById(id);
		return opt;
		
	}

	@Override
	public List<Resume> getAllResume() {
		List<Resume> list = repo.findAll();
		return list;
	}

}
