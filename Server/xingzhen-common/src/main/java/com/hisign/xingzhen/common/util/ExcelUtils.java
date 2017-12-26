package com.hisign.xingzhen.common.util;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author 何建辉
 */
public class ExcelUtils {

	private ExcelUtils(){}
	
	public static String cell2String(Cell cell){
		String temp = "";  
        if (cell == null) {  
            temp = "";  
        } else {
            int cellType = cell.getCellType();  
            switch (cellType) {  
            case Cell.CELL_TYPE_STRING:  
                temp = cell.getStringCellValue().trim();  
                temp = StringUtils.isEmpty(temp) ? "" : temp;  
                break;  
            case Cell.CELL_TYPE_BOOLEAN:  
                temp = String.valueOf(cell.getBooleanCellValue());  
                break;  
            case Cell.CELL_TYPE_FORMULA:  
                temp = String.valueOf(cell.getCellFormula().trim());  
                break;  
            case Cell.CELL_TYPE_NUMERIC:  
                if (HSSFDateUtil.isCellDateFormatted(cell)) {  
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    temp = sdf.format(date);
                } else {  
                    temp = new DecimalFormat("#.######").format(cell.getNumericCellValue());  
                }  
                break;  
            case Cell.CELL_TYPE_BLANK:  
                temp = "";  
                break;  
            case Cell.CELL_TYPE_ERROR:  
            	temp = null;
                break;  
            default:  
                temp = cell.toString().trim();  
                break;  
            }  
        }
        return temp;
	}
	
	public static Object cell2Object(Cell cell){
		Object temp = "";  

        int cellType = cell.getCellType();  
        switch (cellType) {  
        case Cell.CELL_TYPE_STRING:  
            temp = cell.getStringCellValue().trim();  
            break;  
        case Cell.CELL_TYPE_BOOLEAN:  
            temp = cell.getBooleanCellValue();  
            break;  
        case Cell.CELL_TYPE_FORMULA:  
            temp = cell.getCellFormula().trim();  
            break;  
        case Cell.CELL_TYPE_NUMERIC:  
            if (HSSFDateUtil.isCellDateFormatted(cell)) {  
                temp = cell.getDateCellValue();
            } else {  
                temp = cell.getNumericCellValue();  
            }  
            break;  
        case Cell.CELL_TYPE_BLANK:  
            temp = "";  
            break;  
        case Cell.CELL_TYPE_ERROR:  
        	temp = null;
            break;  
        default:  
            temp = cell.toString().trim();  
            break;  
        }
    
        return temp;
	}
	
	public static <T> List<T> excel_xlsx2Bean(InputStream is,List<String> fieldNameList,Class<T> clazz) throws Exception{
		Workbook hssfWorkbook = new XSSFWorkbook(is);
		Sheet sheet = hssfWorkbook.getSheetAt(0);
		List<T> list = new ArrayList<T>();
		for(Row row : sheet){
			int rowNum = row.getRowNum();
			if (rowNum==0) {
				continue;
			}else {
				T obj = clazz.newInstance();
				for(Cell cell : row){
					int columnIndex = cell.getColumnIndex();
					Field field = clazz.getDeclaredField(fieldNameList.get(columnIndex));
					if (field!=null) {
						field.setAccessible(true);
						Object value = cell2Object(cell);
						field.set(obj, value);
					}
				}
				list.add(obj);
			}
		}
		hssfWorkbook.close();
		return list;
	}
	
	
	public static <T> List<T> excel_xlsx2Bean(File file,List<String> fieldNameList,Class<T> clazz) throws Exception{
		return excel_xlsx2Bean(new FileInputStream(file),fieldNameList, clazz);
	}
	
	
	public static <T> List<T> excel_xls2Bean(File file,List<String> fieldNameList,Class<T> clazz) throws Exception{
		return excel_xls2Bean(file,fieldNameList, clazz);
	}
	
	public static <T> List<T> excel_xls2Bean(InputStream is,List<String> fieldNameList,Class<T> clazz) throws Exception{
		try {
			POIFSFileSystem poifsFileSystem = new POIFSFileSystem(is);  
			Workbook workbook = new HSSFWorkbook(poifsFileSystem);  
			  
			Sheet sheet = workbook.getSheetAt(0);
			
			int rowStart = sheet.getFirstRowNum() + 1;  
	        int rowEnd = sheet.getLastRowNum();  
	        
	        List<T> list = new ArrayList<T>();
	        
	        for(int i = rowStart; i <= rowEnd; i++) {  
	            Row row = sheet.getRow(i);        
	            int rowNum = row.getRowNum();
				if (rowNum==0) {
					continue;
				}else {
					T obj = clazz.newInstance();
					for(Cell cell : row){
						int columnIndex = cell.getColumnIndex();
						Field field = clazz.getDeclaredField(fieldNameList.get(columnIndex));
						if (field!=null) {
							field.setAccessible(true);
							Object value = cell2Object(cell);
							field.set(obj, value);
						}
					}
					list.add(obj);
				}
	        }  
	        workbook.close();
			return list;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return null;
	}
	
	public static List<String> row2List(Row row){
		List<String> list = new ArrayList<String>();
		for(Cell cell : row){
			String temp = cell2String(cell);
			list.add(temp);
		}
		return list;
	}
	
	/**
	 * 类名: ExcelUtils.java
	 * 描述: 合并行转list
	 * 公司: 北京海鑫科金高科技股份有限公司
	 * 作者: 何建辉
	 * 版本: 
	 * 参数: @param row
	 * 参数: @return
	 * 创建时间: 2017年5月18日
	 * 最后修改时间: 2017年5月18日
	 */
	public static List<String> combineRow2List(List<CellRangeAddress> listCombineCell,Sheet sheet,Row row){
		List<String> list = new ArrayList<String>();
		for(Cell cell : row){
			String temp = "";
			try {
				temp = isCombineCell(listCombineCell, cell, sheet);
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(temp);
		}
		return list;
	}
	
	public static List<List<String>> excel_xls2List(InputStream is){
		try {
			POIFSFileSystem poifsFileSystem = new POIFSFileSystem(is);  
			Workbook workbook = new HSSFWorkbook(poifsFileSystem);  
			  
			Sheet sheet = workbook.getSheetAt(0);
			
			int rowStart = sheet.getFirstRowNum() + 1;  
	        int rowEnd = sheet.getLastRowNum();  
	        
	        List<List<String>> list = new ArrayList<List<String>>();
	        
	        List<CellRangeAddress> combineCell = getCombineCell(sheet);
	        
	        for(int i = rowStart; i <= rowEnd; i++) {  
	            Row row = sheet.getRow(i);        
	            int rowNum = row.getRowNum();
				if (rowNum==0) {
					continue;
				}else {
					List<String> rowList = combineRow2List(combineCell, sheet, row);
					list.add(rowList);
				}
	        }  
	        workbook.close();
			return list;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return null;
	}
	
	public static List<List<String>> excel_xlsx2List(InputStream is){
		try {
			Workbook hssfWorkbook = new XSSFWorkbook(is);
			Sheet sheet = hssfWorkbook.getSheetAt(1);
			List<List<String>> list = new ArrayList<List<String>>();
			
			List<CellRangeAddress> combineCell = getCombineCell(sheet);
			
			for(Row row : sheet){
				int rowNum = row.getRowNum();
				if (rowNum==0) {
					continue;
				}else {
					List<String> rowList = combineRow2List(combineCell, sheet, row);
					list.add(rowList);
				}
			}
			hssfWorkbook.close();
			return list;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
		return null;
	}
	
	public static List<List<String>> excel2List(String fileName,InputStream fis) throws Exception{
		int index = fileName.toLowerCase().lastIndexOf(".xlsx");
		if (index>0) {
			return excel_xlsx2List(fis);
		}else {
			return excel_xls2List(fis);
		}
	}
	
	public static <T> List<T> excel2Bean(File file,List<String> fieldNameList,Class<T> clazz) throws Exception{
		String name = file.getName();
		int index = name.toLowerCase().lastIndexOf(".xls");
		if (index>0) {
			return excel_xls2Bean(file, fieldNameList, clazz);
		}else {
			index = name.toLowerCase().lastIndexOf(".xlsx");
			if (index>0) {
				return excel_xlsx2Bean(file, fieldNameList, clazz);
			}
		}
		return null;
	}
	
	public static <T> List<T> excel2Bean(String fileName,InputStream fis,List<String> fieldNameList,Class<T> clazz) throws Exception{
		int index = fileName.toLowerCase().lastIndexOf(".xls");
		if (index>0) {
			return excel_xls2Bean(fis, fieldNameList, clazz);
		}else {
			index = fileName.toLowerCase().lastIndexOf(".xlsx");
			if (index>0) {
				return excel_xlsx2Bean(fis, fieldNameList, clazz);
			}
		}
		return null;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Workbook createWorkBook(List li, String []keys, String[] columnNames) {
		
		List<Map<String,Object>> list = ClassUtils.list2Map(li);
		
        // 创建excel工作簿
        Workbook wb = new HSSFWorkbook();
        // 创建第一个sheet（页），并命名
        Sheet sheet = wb.createSheet("sheet1");
        // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
        for(int i=0;i<keys.length;i++){
            sheet.setColumnWidth((short) i, (short) (35.7 * 150));
        }

        // 创建第一行
        Row row = sheet.createRow((short) 0);

        // 创建两种单元格格式
        CellStyle cs = wb.createCellStyle();
        CellStyle cs2 = wb.createCellStyle();

        // 创建两种字体
        Font f = wb.createFont();
        Font f2 = wb.createFont();

        // 创建第一种字体样式（用于列名）
        f.setFontHeightInPoints((short) 12);
        f.setColor(IndexedColors.BLACK.getIndex());
        f.setBoldweight(Font.BOLDWEIGHT_BOLD);

        // 创建第二种字体样式（用于值）
        f2.setFontHeightInPoints((short) 10);
        f2.setColor(IndexedColors.BLACK.getIndex());

        // 设置第一种单元格的样式（用于列名）
        cs.setFont(f);
        cs.setBorderLeft(CellStyle.BORDER_THIN);
        cs.setBorderRight(CellStyle.BORDER_THIN);
        cs.setBorderTop(CellStyle.BORDER_THIN);
        cs.setBorderBottom(CellStyle.BORDER_THIN);
        cs.setAlignment(CellStyle.ALIGN_CENTER);

        // 设置第二种单元格的样式（用于值）
        cs2.setFont(f2);
        cs2.setBorderLeft(CellStyle.BORDER_THIN);
        cs2.setBorderRight(CellStyle.BORDER_THIN);
        cs2.setBorderTop(CellStyle.BORDER_THIN);
        cs2.setBorderBottom(CellStyle.BORDER_THIN);
        cs2.setAlignment(CellStyle.ALIGN_CENTER);
        //设置列名
        for(int i=0;i<columnNames.length;i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(cs);
        }
        //设置每行每列的值
        for (short i = 1; i <= list.size(); i++) {
            // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
            // 创建一行，在页sheet上
            Row row1 = sheet.createRow((short) i);
            // 在row行上创建一个方格
            for(short j=0;j<keys.length;j++){
                Cell cell = row1.createCell(j);
                cell.setCellValue(list.get(i-1).get(keys[j]) == null?" ": list.get(i-1).get(keys[j]).toString());
                cell.setCellStyle(cs2);
            }
        }
        return wb;
    }
	
	
	/**
	 * 合并单元格处理,获取合并行
	 * 
	 * @param sheet
	 * @return List<CellRangeAddress>
	 */
	public static List<CellRangeAddress> getCombineCell(Sheet sheet) {
		List<CellRangeAddress> list = new ArrayList<CellRangeAddress>();
		// 获得一个 sheet 中合并单元格的数量
		int sheetmergerCount = sheet.getNumMergedRegions();
		// 遍历合并单元格
		for (int i = 0; i < sheetmergerCount; i++) {
			// 获得合并单元格加入list中
			CellRangeAddress ca = sheet.getMergedRegion(i);
			list.add(ca);
		}
		return list;
	}
	
	/**
	 * 判断单元格是否为合并单元格，是的话则将单元格的值返回
	 * 
	 * @param listCombineCell
	 *            存放合并单元格的list
	 * @param cell
	 *            需要判断的单元格
	 * @param sheet
	 *            sheet
	 * @return
	 */
	public static String isCombineCell(List<CellRangeAddress> listCombineCell,
			Cell cell, Sheet sheet) throws Exception {
		int firstC = 0;
		int lastC = 0;
		int firstR = 0;
		int lastR = 0;
		String cellValue = null;
		for (CellRangeAddress ca : listCombineCell) {
			// 获得合并单元格的起始行, 结束行, 起始列, 结束列
			firstC = ca.getFirstColumn();
			lastC = ca.getLastColumn();
			firstR = ca.getFirstRow();
			lastR = ca.getLastRow();
			if (cell.getRowIndex() >= firstR && cell.getRowIndex() <= lastR) {
				if (cell.getColumnIndex() >= firstC
						&& cell.getColumnIndex() <= lastC) {
					Row fRow = sheet.getRow(firstR);
					Cell fCell = fRow.getCell(firstC);
					cellValue = fCell.getStringCellValue();
					break;
				}
			} else {
				cellValue = cell2String(cell);
			}
		}
		return cellValue;
	}
	
	
	@SuppressWarnings("deprecation")
	public static Object createWorkBook(List<List<String>> li, String[] columnNames) {
        // 创建excel工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
        // 创建第一个sheet（页），并命名
        HSSFSheet sheet = wb.createSheet("sheet1");
        // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
        for(int i=0;i<columnNames.length;i++){
            sheet.setColumnWidth((short) i, (short) (40 * 120));
        }

        // 创建第一行
        HSSFRow row = sheet.createRow((short) 0);

        // 创建两种单元格格式
        CellStyle cs = wb.createCellStyle();
        CellStyle cs2 = wb.createCellStyle();

        // 创建两种字体
        Font f = wb.createFont();
        Font f2 = wb.createFont();

        // 创建第一种字体样式（用于列名）
        f.setFontHeightInPoints((short) 12);
        f.setColor(IndexedColors.BLACK.getIndex());
        f.setBoldweight(Font.BOLDWEIGHT_BOLD);

        // 创建第二种字体样式（用于值）
        f2.setFontHeightInPoints((short) 11);
        f2.setColor(IndexedColors.BLACK.getIndex());

        // 设置第一种单元格的样式（用于列名）
        cs.setFont(f);
        cs.setBorderLeft(CellStyle.BORDER_THIN);
        cs.setBorderRight(CellStyle.BORDER_THIN);
        cs.setBorderTop(CellStyle.BORDER_THIN);
        cs.setBorderBottom(CellStyle.BORDER_THIN);
        cs.setAlignment(CellStyle.ALIGN_CENTER);

        // 设置第二种单元格的样式（用于值）
        cs2.setFont(f2);
        cs2.setBorderLeft(CellStyle.BORDER_THIN);
        cs2.setBorderRight(CellStyle.BORDER_THIN);
        cs2.setBorderTop(CellStyle.BORDER_THIN);
        cs2.setBorderBottom(CellStyle.BORDER_THIN);
        cs2.setAlignment(CellStyle.ALIGN_CENTER);
        
        //居中
        HSSFCellStyle style=wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
        
        //设置列名
        for(int i=0;i<columnNames.length;i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(cs);
        }
        //设置每行每列的值
        for (short i = 1; i <= li.size(); i++) {
            // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
            // 创建一行，在页sheet上
        	List<String> list = li.get(i-1);
        	
        	HSSFRow row1 = null;
        	row1 = sheet.createRow(i);
        	
        	for (int j = 0; j < list.size(); j++) {
        		Cell cell = row1.createCell(j);
            	cell.setCellStyle(style);
            	cell.setCellValue(list.get(j));
			}
        }
        return wb;
    }
	
	public static Workbook createWorkBook(File file) throws IOException, EncryptedDocumentException, InvalidFormatException{
//		File file = new File("D:/orgExpen.xlsx");
//		Workbook workbook = new XSSFWorkbook(file);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		fis.close();
		return workbook;
	}
	
	public static Workbook getNomalCellStyle(Workbook workbook){
		CellStyle cs = workbook.createCellStyle();
		Font f = workbook.createFont();
        f.setFontHeightInPoints((short) 11);
        f.setColor(IndexedColors.BLACK.getIndex());
        cs.setFont(f);
        cs.setBorderLeft(CellStyle.BORDER_THIN);
        cs.setBorderRight(CellStyle.BORDER_THIN);
        cs.setBorderTop(CellStyle.BORDER_THIN);
        cs.setBorderBottom(CellStyle.BORDER_THIN);
        cs.setAlignment(CellStyle.ALIGN_CENTER);
        
        return workbook;
	}
	
}
