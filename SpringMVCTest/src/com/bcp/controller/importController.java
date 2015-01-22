package com.bcp.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcp.dao.uploadFileDAO;
import com.bcp.modelo.dto.ExcelfileDTO;
import com.google.appengine.api.blobstore.BlobInfoFactory;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

@Controller
@RequestMapping("/upload")
public class importController {
	
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	private static final String extensionXLS="XLS";
	private static final String extensionXLSX="XLSX";
	private static final String extensionXLSM="XLSM";
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadFile(HttpServletRequest request, 
            HttpServletResponse response) throws IOException,Exception {
		
		String extension = "";
		
		List<ExcelfileDTO> excelfileDTOList = new ArrayList<ExcelfileDTO>();
		ExcelfileDTO excelFileDTO = null;
		
		POIFSFileSystem fileSystem = null;
		
		Workbook workBook = null;
		Sheet sheet = null;

		try {
			if(ServletFileUpload.isMultipartContent(request)){
											
				Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(request);
			    BlobKey blobKey = blobs.get("file").get(0);
			    
			    BlobInfoFactory info = new BlobInfoFactory();
			    
			    extension = info.loadBlobInfo(blobKey).getFilename().replace(".", "@@");
			    extension = extension.split("@@")[1];
		
				if(extension.toUpperCase().compareTo(extensionXLS)==0){
					
					byte[] bytes = blobstoreService.fetchData(blobKey, 0, BlobstoreService.MAX_BLOB_FETCH_SIZE-1);
					fileSystem = new POIFSFileSystem(new ByteArrayInputStream(bytes));
					
					workBook = new HSSFWorkbook (fileSystem);		
					sheet =  workBook.getSheetAt(1);
					
				}else if(extension.toUpperCase().compareTo(extensionXLSX)==0 ||
						extension.toUpperCase().compareTo(extensionXLSM)==0){
					
					byte[] bytes = blobstoreService.fetchData(blobKey, 0, BlobstoreService.MAX_BLOB_FETCH_SIZE-1);
					workBook = new XSSFWorkbook(new ByteArrayInputStream(bytes));
//					System.out.println(workBook.getSheetName(1));
					sheet =  workBook.getSheetAt(1);
					
				}
				
	            int totalCellRowCount = 0;

	            for(Row row : sheet){
	            	
	            	excelFileDTO = new ExcelfileDTO();
	            	
	            	if(row.getRowNum() <= 2){
	            		continue;
	            	}
	            	else if(row.getRowNum() == 3){
	            		totalCellRowCount = row.getLastCellNum();
	            		continue;
	            	}
	            	 
	            	//Lee a partir de la 4 fila.
	            	for(int count = 0; count < totalCellRowCount; count++) {
	            		Cell cell = row.getCell(count, Row.CREATE_NULL_AS_BLANK);
	            		
	            		String cellValue = "";
	            		
	            		switch (cell.getCellType ()){
	            		 	case HSSFCell.CELL_TYPE_NUMERIC : //TIPO DE DATO NUMERICO Y FECHA
		                        {  
		                        	if(HSSFDateUtil.isCellDateFormatted(cell)){
		                        		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		                        		
		                        		cellValue = sdf.format(cell.getDateCellValue());
		   	            			 	break;		   	            			 	
		                        	}else{		                        		
		                        		cellValue = new BigDecimal(cell.getNumericCellValue()).toPlainString();
			                            break;
		                        	}
		                        }
	            		 	case HSSFCell.CELL_TYPE_STRING : //TIPO DE DATO STRING
		                        {		                        	
		                            RichTextString richTextString = cell.getRichStringCellValue();
		                            cellValue = richTextString.getString();
		                            break;
		                        }
	            		 	case HSSFCell.CELL_TYPE_BLANK: //TIPO DE DATO NULL
	            		 		{	
	            		 			RichTextString richTextString = cell.getRichStringCellValue();
	            		 			cellValue = richTextString.getString();
	            		        break;
	            		 		}
	            		 	case HSSFCell.CELL_TYPE_FORMULA: //TIPO DE DATO FORMULA
	            		 		{
	            		 			switch(cell.getCachedFormulaResultType()) {
		            		 			case HSSFCell.CELL_TYPE_STRING:
		            		 			     RichTextString richTextString = cell.getRichStringCellValue();
		            		 			    cellValue = richTextString.getString();
		            		 			     break;
		            		 			  case HSSFCell.CELL_TYPE_NUMERIC:
		            		 				 cellValue = new BigDecimal(cell.getNumericCellValue()).toPlainString();
		            		 			     break;
		            		 			  case HSSFCell.CELL_TYPE_BOOLEAN:
		            		 				 cellValue = String.valueOf(cell.getBooleanCellValue());
		            		 			     break;
		            		 			  case HSSFCell.CELL_TYPE_ERROR:
		            		 				 cellValue = ErrorEval.getText(cell.getErrorCellValue());
		            		 			     break;
	            		 			}
	            		 			break;
	            		 		}
	                        default : //TIPO DE DATO NO VALIDO
		                     	{
		                     		RichTextString richTextString = cell.getRichStringCellValue();
		                            cellValue = richTextString.getString();
		                            break;
		                        }
	            		}
//	            		System.out.println((count+1)+". Test value :: " + cellValue);
	            		excelFileDTO.sendDataDTO(count+1, cellValue);
	            	 }
//	            	System.out.println("*****************PRUEBA******************");
	            	excelfileDTOList.add(excelFileDTO);
	            	break;
	            }
	            
				blobstoreService.delete(blobKey);
			}
			
			String result = uploadFileDAO.getInstancia().insertDataFileUpload(excelfileDTOList);			
			System.out.println(result);
			
		}catch(IOException io){				
			io.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
        return "importExcel/importExcel"; 
    }
	
}
