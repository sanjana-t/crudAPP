package com.cwacrudapp.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cwacrudapp.demo.model.SheetToDb;
import com.cwacrudapp.demo.repository.SheetToDbRepository;

@RestController
public class SheetToDbController {
	
	@Autowired
	private SheetToDbRepository repo;

	public static boolean checkExcelFormat(MultipartFile file) {
		
		String contentType = file.getContentType();
		
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<SheetToDb> convertExcelToList(InputStream is){
		
		List<SheetToDb> list = new ArrayList<>();
		
		try {
			
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			
			int rowNumber =0;
			
			Iterator<Row> iterator=sheet.iterator();
			
			while(iterator.hasNext()) {
				Row row= iterator.next();
				
				if (rowNumber ==0) {
					rowNumber++;
					continue;
				}
				
				Iterator<Cell> cells = row.iterator();
				
				int cid =0;
				
				SheetToDb p = new SheetToDb();
				
				while(cells.hasNext()) {
					
					Cell cell = cells.next();
					
					switch(cid) {
					
					case 0: 
//						int numericCellValue = cell.getNumericCellValue();
						p.setClientId((int)cell.getNumericCellValue());
						break;
							
					case 1:
						p.setSubClientId((int)cell.getNumericCellValue());
						break;
					case 2:
						p.setResearchTypeId((int)cell.getNumericCellValue());
						break;
					case 3:
						p.setSubResearchTypeId((int)cell.getNumericCellValue());
						break;
					case 4:
						p.setIndustryId((int)cell.getNumericCellValue());
						break;
					case 5:
						p.setLanguageId((int)cell.getNumericCellValue());
						break;
					case 6:
						p.setQuestionSelection(cell.getStringCellValue());
						break;
					case 7:
						p.setQuestionSection(cell.getStringCellValue());
						break;
					case 8:
						p.setqId(cell.getStringCellValue());
						break;
					case 9: 
						p.setqType(cell.getStringCellValue());
						break;
					case 10:
						p.setQuestionCategory(cell.getStringCellValue());
						break;
					case 11:
						p.setQuestionText(cell.getStringCellValue());
						break;
					case 12:
						p.setRowAnswerOptions(cell.getStringCellValue());
						break;
					case 13:
						p.setColumnAnswerOptions(cell.getStringCellValue());
						break;
					case 14:
						p.setInsturction(cell.getStringCellValue());
						break;
					case 15:
						p.setConditionType(cell.getStringCellValue());
						break;
					case 16:
						p.setConditionText(cell.getStringCellValue());
						break;
					
					
					}
					cid++;		
				}
				
				list.add(p);
				
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public void save(MultipartFile file) {
	
		try {
			List<SheetToDb> ps =convertExcelToList(file.getInputStream());
			this.repo.saveAll(ps);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<SheetToDb> getAllData(){
		return this.repo.findAll();
	}
	
	@PostMapping("/question/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		
		if(checkExcelFormat(file)) {
			save(file);
			return ResponseEntity.ok(Map.of("msg","file is uploaded and data is saved to db"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel file only");
	}
	
	@GetMapping("/questions")
	public List<SheetToDb> getQuestions(){
		return getAllData();
	}
	
}
