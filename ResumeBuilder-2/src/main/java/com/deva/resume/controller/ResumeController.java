package com.deva.resume.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.deva.resume.model.Resume;
import com.deva.resume.pdfUtil.ResumePdfView;
import com.deva.resume.service.IResumeService;

@Controller
public class ResumeController {
	
	@Autowired
	private   IResumeService service;
	
	@RequestMapping("/resume")
	public static String showResume() {

		return "ResumeBuilder";	
	}
	
	//2. On click submit button read form -> save data
	@RequestMapping("/save")
	public String saveResume(@ModelAttribute Resume resume,Model model	) {
		
	
		//call service 
		Integer id = service.saveResume(resume);
		//creaete message
	
		Optional<Resume> list = service.getOneResume(id);
		//send message ti ui
		model.addAttribute("list", list.get());
		//go back to same page		
		return "ResumeSingleView";
		
		
	}
	/*
	@RequestMapping("/all")
	public String showAll(@ModelAttribute Resume resume,Model model	) {
		
	

		List<Resume> list = service.getAllResume();
		//send message ti ui
		model.addAttribute("list", list);
		//go back to same page		
		return "ResumePreview";
		
		
	}*/
	@RequestMapping("/pdf")
	public ModelAndView exportToPdf(@RequestParam("id")Integer sid)
	{
		//fetch all rows from DB
		Optional<Resume> opt = service.getOneResume(sid);
		
		//create ModelAndView
		ModelAndView  m = new ModelAndView();
		m.addObject("r", opt.get());
	
		
		m.setView(new ResumePdfView());
		return m;
	}

	@RequestMapping("/all")
	public String showAllResume(
			Model model	) 
	{
		// call service layer
		List<Resume> list = service.getAllResume();

		//send data to UI
		model.addAttribute("list", list);

		//Go back to UI page
		return "ResumePreview";
	}

}
