package com.deva.resume.pdfUtil;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.deva.resume.model.Resume;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ResumePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception
	{
			
		   final Font titleFont  = FontFactory.getFont(FontFactory.TIMES_ROMAN, 20, Font.BOLD);
		    final Font headerFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
		    final Font normalFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.NORMAL);
		    final Font smallFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 4, Font.NORMAL);
		    
		   
		    
		    
		//provide file name for pdf
		response.addHeader("Content-Disposition", "attachment;filename=Resume.pdf");
	
		//Resume model 
		Resume r = (Resume) model.get("r");
		
		// create element
		Paragraph title = new Paragraph(r.getName().toUpperCase(),titleFont);
		title.setAlignment(Element.ALIGN_CENTER);
		Paragraph lln =new Paragraph("\n\n");
		Paragraph ln =new Paragraph("\n");
		
		//comunication details
		String email= "Email:"+r.getEmail().toLowerCase();
		 String mobile = "Mobile:"+r.getMobileNumber();
		PdfPTable table1 = new PdfPTable(2);
		table1.setWidthPercentage(90);
		PdfPCell cell1 = new PdfPCell(new Phrase(email,normalFont ));
		cell1.setBorder(Rectangle.NO_BORDER);
		cell1.setHorizontalAlignment(0);
		PdfPCell cell2 = new PdfPCell(new Phrase(mobile,normalFont ));
		cell2.setBorder(Rectangle.NO_BORDER);
		cell2.setHorizontalAlignment(2);
		
		table1.addCell(cell1);
		table1.addCell(cell2);
		
		PdfPCell cell5 = new PdfPCell(new Phrase("____________________________________________________________________________________",normalFont ));
		cell5.setBorder(Rectangle.NO_BORDER);
		cell5.setColspan(2);
	
		table1.addCell(cell5);
		//Career Objective
		PdfPCell cell3 = new PdfPCell(new Phrase("Career Objective",headerFont ));
		cell3.setColspan(2);
		cell3.setBorder(Rectangle.NO_BORDER);
		cell3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		
		PdfPCell cell4 = new PdfPCell(new Phrase("    "+r.getCareerObjective(),normalFont ));
		cell4.setColspan(2);
		cell4.setBorder(Rectangle.NO_BORDER);
		cell4.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table1.addCell(cell3);
		table1.addCell(cell4);




		PdfPTable table = new PdfPTable(5);
		table.setSpacingAfter(5);
		table.setWidthPercentage(90);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		
		PdfPCell cell6 = new PdfPCell(new Phrase("Educational Qualifications:",headerFont));
		cell6.setColspan(5);
		cell6.setBorder(Rectangle.NO_BORDER);
		cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell6.setExtraParagraphSpace(5);
		table.addCell(cell6);
		
		

		 	table.addCell(new Phrase("Cource",headerFont));

		 	table.addCell(new Phrase("Institute",headerFont));

		 	table.addCell(new Phrase("University",headerFont));

		 	table.addCell(new Phrase("Duration",headerFont));

		 	table.addCell(new Phrase("Percentage",headerFont));
		
			 table.addCell(new Phrase(r.getCourse1(),normalFont) );

			 table.addCell(new Phrase(r.getInstitute1(),normalFont) );

			 table.addCell(new Phrase(r.getUniversity1(),normalFont));

			 table.addCell(new Phrase(r.getDuration1(),normalFont));

			 table.addCell(new Phrase(r.getPercentage1(),normalFont));
			 
			 
			 table.addCell(new Phrase(r.getCourse2(),normalFont) );

			 table.addCell(new Phrase(r.getInstitute2(),normalFont) );

			 table.addCell(new Phrase(r.getUniversity2(),normalFont));

			 table.addCell(new Phrase(r.getDuration2(),normalFont));

			 table.addCell(new Phrase(r.getPercentage2(),normalFont));
			 

			 table.addCell(new Phrase(r.getCourse3(),normalFont) );

			 table.addCell(new Phrase(r.getInstitute3(),normalFont) );

			 table.addCell(new Phrase(r.getUniversity3(),normalFont));

			 table.addCell(new Phrase(r.getDuration3(),normalFont));

			 table.addCell(new Phrase(r.getPercentage3(),normalFont));
			 //Strenths
			
			PdfPTable table3 = new PdfPTable(3);
			table3.setWidthPercentage(90);
			PdfPCell cel = new PdfPCell(new Phrase("Strenths",headerFont));
			cel.setColspan(3);
			cel.setBorder(Rectangle.NO_BORDER);
		
			table3.addCell(cel);
			PdfPCell cel1 = new PdfPCell(new Phrase(r.getStrengths(),normalFont));
			cel1.setColspan(3);
			cel1.setBorder(Rectangle.NO_BORDER);
			table3.addCell(cel1);
		
			//Technical skills
			PdfPCell cel2 = new PdfPCell(new Phrase("Technical Skills ",headerFont));
			cel2.setColspan(3);
			cel2.setBorder(Rectangle.NO_BORDER);
			table3.addCell(cel2);
			
			PdfPCell cel3 = new PdfPCell(new Phrase(r.getTechnicalSkill(),normalFont));
			cel3.setColspan(3);
			
			cel3.setBorder(Rectangle.NO_BORDER);
			table3.addCell(cel3);
		
			PdfPCell cel21 = new PdfPCell(new Phrase("  ",headerFont));
			cel21.setColspan(3);
			cel21.setBorder(Rectangle.NO_BORDER);
			table3.addCell(cel21);
			
			PdfPCell cel221 = new PdfPCell(new Phrase("Personal Information",headerFont));
			cel221.setColspan(3);
			cel221.setBorder(Rectangle.NO_BORDER);
			table3.addCell(cel221);
			
			PdfPCell cel2212 = new PdfPCell(new Phrase("",normalFont));
			cel2212.setColspan(3);
			cel2212.setBorder(Rectangle.NO_BORDER);
			table3.addCell(cel2212);
			
			//Father Name
			PdfPCell cel31 = new PdfPCell(new Phrase("Father Name 	",normalFont));
			cel31.setColspan(1);
			cel31.setBorder(Rectangle.NO_BORDER);
			table3.addCell(cel31);
			
			PdfPCell cel32 = new PdfPCell(new Phrase(":"+r.getFatherName(),normalFont));
			cel32.setColspan(2);
			cel32.setBorder(Rectangle.NO_BORDER);
			table3.addCell(cel32);
		
			//Father Name
			PdfPCell cel33 = new PdfPCell(new Phrase("Date of Birth  	",normalFont));
			cel33.setColspan(1);
			cel33.setBorder(Rectangle.NO_BORDER);
			table3.addCell(cel33);
			
			PdfPCell cel34 = new PdfPCell(new Phrase(":"+r.getDateOfBirth(),normalFont));
			cel34.setColspan(2);
			cel34.setBorder(Rectangle.NO_BORDER);
			table3.addCell(cel34);
			 

			// Languages 
			PdfPCell ce01 = new PdfPCell(new Phrase("Languages",normalFont));
			ce01.setColspan(1);
			ce01.setBorder(Rectangle.NO_BORDER);
			table3.addCell(ce01);
			
			PdfPCell ce02 = new PdfPCell(new Phrase(":"+r.getLanguages(),normalFont));
			ce02.setColspan(2);
			ce02.setBorder(Rectangle.NO_BORDER);
			table3.addCell(ce02);
			
			PdfPTable tfoot = new PdfPTable(2);
			tfoot.setWidthPercentage(90);
			
			PdfPCell ce03 = new PdfPCell(new Phrase(" ",titleFont));
			ce03.setColspan(2);
			ce03.setBorder(Rectangle.NO_BORDER);
			tfoot.addCell(ce03);
			
			PdfPCell ce04 = new PdfPCell(new Phrase(" ",titleFont));
			ce04.setColspan(2);
			ce04.setBorder(Rectangle.NO_BORDER);
			tfoot.addCell(ce04);
			
			//footer
			PdfPCell ce05 = new PdfPCell(new Phrase("Date:",normalFont));
			
			ce05.setColspan(1);
			ce05.setHorizontalAlignment(0);
			ce05.setBorder(Rectangle.NO_BORDER);
			tfoot.addCell(ce05);
			
			PdfPCell ce07 = new PdfPCell(new Phrase(""+r.getName()+"",normalFont));
			ce07.setColspan(1);
			ce07.setHorizontalAlignment(Element.ALIGN_RIGHT);
			ce07.setBorder(Rectangle.NO_BORDER);
			tfoot.addCell(ce07);
			
			
			
		// add element to document
		document.add(title);
		document.add(lln);
		document.add(table1);
	
		
//		document.add(mobile);

		document.add(table);
		
		document.add(table3);
		document.add(tfoot);
	
}}