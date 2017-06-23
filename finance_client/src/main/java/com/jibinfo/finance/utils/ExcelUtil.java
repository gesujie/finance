/*
 *  =========================================================================
 *   Copyright(c) 2015-2016. Jibinfo System Inc. All Rights Reserved.
 *
 *   注意:本内容仅限于南京坚卓软件科技公司内部传阅，禁止外泄以及用于其他的商业目的
 *  =========================================================================
 *
 */

package com.jibinfo.finance.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.jibinfo.finance.exception.SensitiveException;
import com.jibinfo.finance.vo.util.ExcelBaseTo;
import com.jibinfo.framework.support.utility.DateUtility;


public class ExcelUtil {

    private static Logger logger = Logger.getLogger(ExcelUtil.class);

    public static final String EXCEL_DATE_PATTERN = "YYYY/MM/dd";
    
    
    

    /**
     * Convert Data from Excel to Object
     *
     * @param fileIS
     * @param sheetNum
     * @param startRowNum
     * @param convertionType
     * @return
     * @throws Exception
     */
    public static <T extends ExcelBaseTo> List<T> converExcelToObject(
            InputStream fileIS, int sheetNum, int startRowNum,
            Class<T> convertionType) throws Exception {

        List<T> resultList = new ArrayList<T>();

        Workbook workbook = null;
        try {
            try {
                workbook = WorkbookFactory.create(fileIS);
            } catch (Exception ex) {
                logger.error(ex.getMessage(), ex);
                throw new SensitiveException(MessageConstants.EXCEL_PARSE_FAIL);
            }

            Sheet sheet = workbook.getSheetAt(sheetNum);
            if (sheet == null) {
                throw new SensitiveException(MessageConstants.EXCEL_PARSE_FAIL);
            }

            int lastRowNum = sheet.getLastRowNum();
            if (startRowNum > lastRowNum) {
                throw new SensitiveException(MessageConstants.EXCEL_DATA_EMPTY);
            }

            for (int rowNum = startRowNum; rowNum <= lastRowNum; rowNum++) {
                Row row = sheet.getRow(rowNum);

                if (row == null) {
                    continue;
                }

                T t = convertionType.newInstance();
                t.setRowNo(Long.valueOf(rowNum));

                Map<Integer, String> cellAttrMapping = t.getCellAttrMapping();

                Set<Entry<Integer, String>> entrySet = cellAttrMapping.entrySet();
                boolean flag = false;
                for (Entry<Integer, String> entry : entrySet) {
                    Integer cellIndex = entry.getKey();
                    String attrName = entry.getValue();

                    Cell cell = row.getCell(cellIndex);

                    if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                        continue;
                    }

                    flag = true;

                    Field field = convertionType.getDeclaredField(attrName);
                    field.setAccessible(true);

                    String cellValue = "";
                    if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                        Date dateCellValue = cell.getDateCellValue();
                        cellValue = DateUtility.format(ExcelUtil.EXCEL_DATE_PATTERN, dateCellValue);
                    } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        DecimalFormat df = new DecimalFormat("0.00#");
                        cellValue = df.format(cell.getNumericCellValue());
                    } else {
                        cellValue = String.valueOf(cell);
                    }
                    field.set(t, cellValue);
                }

                if (flag) {
                    resultList.add(t);
                }
            }
        } catch (SensitiveException e) {
            logger.error(e.getMessage(), e);
            throw new SensitiveException(MessageConstants.EXCEL_PARSE_FAIL);
        }   catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        } finally {
            if (workbook != null) {
                workbook.close();
            }
            try {
                fileIS.close();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }

        return resultList;
    }

    @SuppressWarnings("unchecked")
    public static  <T>  void exportExcel(String title, String[] headers, Map<Integer, String> cellAttrMapping,Collection<T> dataset, OutputStream out,String dateFormat) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        try {

            // 生成一个表格
            HSSFSheet sheet = workbook.createSheet(title);

            // 产生表格标题行
            HSSFRow row = sheet.createRow(0);
            // 标题格式
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
            HSSFFont font = workbook.createFont();
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗显示
            cellStyle.setFont(font);
            for (int i=0;i<headers.length;i++) {
                HSSFCell cell = row.createCell(i);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
                cell.setCellStyle(cellStyle);
            }

            font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);//数据内容正常显示
            cellStyle.setFont(font);

            // 遍历集合数据，产生数据行
            Iterator<T> it = dataset.iterator();
            int index = 0;
            while (it.hasNext()) {
                index++;
                row = sheet.createRow(index);
                T t = it.next();
                Set<Entry<Integer, String>> attrSet = cellAttrMapping.entrySet();
				// boolean flag = false;
                for (Entry<Integer, String> entry : attrSet) {
                    Integer cellIndex = entry.getKey();
                    String attrName = entry.getValue();
                    HSSFCell cell = row.createCell(cellIndex);
                    String getMethodName = "get"
                            + attrName.substring(0, 1).toUpperCase()
                            + attrName.substring(1);

					Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[]{});
                    Object value = getMethod.invoke(t, new Object[]{});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    if (value != null){
                        if (value instanceof Date) {
                            Date date = (Date) value;
                            SimpleDateFormat sdf = null;
                            if (dateFormat!=null){
                                sdf = new SimpleDateFormat(dateFormat);
                            }else {
                                sdf = new SimpleDateFormat(EXCEL_DATE_PATTERN);
                            }

                            textValue = sdf.format(date);
                        } else {
                            // 其它数据类型都当作字符串简单处理
                            textValue = value.toString();
                        }
                        cell.setCellValue(textValue);
                    }
                    cell.setCellStyle(cellStyle);
                }
            }

        } catch (Exception e) {
            logger.error(e);
        }
        try {
            workbook.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
           logger.error(e);
        }

    }

}