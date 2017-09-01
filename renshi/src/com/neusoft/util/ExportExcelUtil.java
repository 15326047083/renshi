package com.neusoft.util;

import java.io.Closeable;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;

public class ExportExcelUtil {
	public static <T> HSSFWorkbook export(HttpServletResponse response, String fileName, String[] excelHeader,Collection<T> dataList) throws Exception {
		// 设置请求
		response.setContentType("application/application/vnd.ms-excel");
		response.setHeader("Content-disposition","attachment;filename=" + URLEncoder.encode(fileName + ".xls", "UTF-8"));
		// 创建一个Workbook，对应一个Excel文件
		HSSFWorkbook wb =null;
		wb = new HSSFWorkbook();
		// 设置标题样式
		HSSFCellStyle titleStyle = wb.createCellStyle();
		// 设置单元格边框样式
		titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框 细边线
		titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框 细边线
		titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框 细边线
		titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框 细边线
		// 设置单元格对齐方式
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
		titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 垂直居中
		// 设置字体样式
		Font titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short) 15); // 字体高度
		titleFont.setFontName("黑体"); // 字体样式
		titleStyle.setFont(titleFont);
		// 在Workbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet(fileName);
		// 标题数组
		String[] titleArray = new String[excelHeader.length];
		// 字段名数组
		String[] fieldArray = new String[excelHeader.length];
		for (int i = 0; i < excelHeader.length; i++) {
			String[] tempArray = excelHeader[i].split("#");// 临时数组 分割#
			titleArray[i] = tempArray[0];
			fieldArray[i] = tempArray[1];
		}
		// 在sheet中添加标题行
		HSSFRow row = sheet.createRow((int) 0);// 行数从0开始
		HSSFCell sequenceCell = row.createCell(0);// cell列 从0开始 第一列添加序号
		sequenceCell.setCellValue("序号");
		sequenceCell.setCellStyle(titleStyle);
		sheet.autoSizeColumn(0);// 自动设置宽度
		// 为标题行赋值
		for (int i = 0; i < titleArray.length; i++) {
			HSSFCell titleCell = row.createCell(i + 1);// 0号位被序号占用，所以需+1
			titleCell.setCellValue(titleArray[i]);
			titleCell.setCellStyle(titleStyle);
			sheet.autoSizeColumn(i + 1);// 0号位被序号占用，所以需+1
		}
		// 数据样式 因为标题和数据样式不同 需要分开设置 不然会覆盖
		HSSFCellStyle dataStyle = wb.createCellStyle();
		// 设置数据边框
		dataStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		dataStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		dataStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		dataStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// 设置居中样式
		dataStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
		dataStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 垂直居中
		// 设置数据字体
		Font dataFont = wb.createFont();
		dataFont.setFontHeightInPoints((short) 12); // 字体高度
		dataFont.setFontName("宋体"); // 字体
		dataStyle.setFont(dataFont);
		// 遍历集合数据，产生数据行
		Iterator<T> it = dataList.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;// 0号位被占用 所以+1
			row = sheet.createRow(index);
			// 为序号赋值
			HSSFCell sequenceCellValue = row.createCell(0);// 序号值永远是第0列
			sequenceCellValue.setCellValue(index);
			sequenceCellValue.setCellStyle(dataStyle);
			sheet.autoSizeColumn(0);
			T t = (T) it.next();
			// 利用反射，根据传过来的字段名数组，动态调用对应的getXxx()方法得到属性值
			for (int i = 0; i < fieldArray.length; i++) {
				HSSFCell dataCell = row.createCell(i + 1);
				dataCell.setCellStyle(dataStyle);
				sheet.autoSizeColumn(i + 1);
				String fieldName = fieldArray[i];
				String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);// 取得对应getXxx()方法
				Class<? extends Object> tCls = t.getClass();// 泛型为Object以及所有Object的子类
				Method getMethod = tCls.getMethod(getMethodName, new Class[] {});// 通过方法名得到对应的方法
				Object value = getMethod.invoke(t, new Object[] {});// 动态调用方,得到属性值
				if (value != null) {
					dataCell.setCellValue(value.toString());// 为当前列赋值
				}
			}
		}
		
		OutputStream outputStream = response.getOutputStream();// 打开流
		wb.write(outputStream);// HSSFWorkbook写入流
//		((Closeable) wb).close();
		outputStream.flush();// 刷新流
		outputStream.close();// 关闭流
		return wb;
	}
}
