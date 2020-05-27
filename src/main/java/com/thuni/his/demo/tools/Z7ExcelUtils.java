package com.thuni.his.demo.tools;


import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public final class Z7ExcelUtils {

    private static final Logger log = Logger.getLogger(Z7ExcelUtils.class);

    public  static  List<Map<String, String>>  SaveAnalysisExcelData(String file) {
        //传入excel全路径
        String filepath = file;
        //获得Workbook工作薄对象
        Workbook workbook = getWorkBook(filepath);
        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
        List<Map<String, String>> list = new ArrayList<>();
        if (workbook != null) {
            for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
                //获得当前sheet工作表
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if (sheet == null) {
                    continue;
                }
                //获得当前sheet的开始行
                int firstRowNum = sheet.getFirstRowNum();
                //获得当前sheet的结束行
                int lastRowNum = sheet.getLastRowNum();
                //循环除了所有行,如果要循环除第一行以外的就firstRowNum+1
                for (int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++) {
                    //获得当前行
                    Row row = sheet.getRow(rowNum);
                    if (row == null) {
                        continue;
                    }
                    //获得当前行的开始列
                    int firstCellNum = row.getFirstCellNum();
                    //获得当前行的列数
                    int lastCellNum = row.getLastCellNum();
                    Map<String, String> cells = new HashMap<String, String>();
                    //循环当前行
                    for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                        Cell cell = row.getCell(cellNum);
                        cells.put(String.valueOf(cellNum), getCellValue(cell));
                    }
                    list.add(cells);
                }
            }
        }
        return list;
    }

//    /**
//     * 业务数据处理部分
//     * @param list
//     */
//    public void savePeopleBranchIntegral(List<Map<String, String>> list){
//        //业务数据保存
//        PeopleBranchIntegral branchIntegral = null;
//        List<PeopleBranchIntegral> branchIntegrals = new ArrayList<>();
//        for (Map<String, String> map : list) {
//            branchIntegral = new PeopleBranchIntegral();
//            for (Map.Entry<String, String> entry : map.entrySet()) {
//                if (entry.getKey().equals("1")) {
//                    branchIntegral.setPeopleName(entry.getValue());
//                }
//                if (entry.getKey().equals("2")) {
//                    branchIntegral.setBranchName(entry.getValue());
//                }
//                if (entry.getKey().equals("6")) {
//                    branchIntegral.setBranchIntegral(entry.getValue());
//                }
//            }
//            branchIntegrals.add(branchIntegral);
//        }
//        branchIntegrals.remove(0);
//        peopleBranchIntegralDao.saveAll(branchIntegrals);
//    }

    /**
     * 检查文件
     * @param file
     * @throws IOException
     */
    public static  void checkFile(MultipartFile file) throws IOException{
        //判断文件是否存在
        if(null == file){
            log.error("文件不存在！");
        }
        //获得文件名
        String fileName = file.getOriginalFilename();
        //判断文件是否是excel文件
        if(!fileName.endsWith("xls") && !fileName.endsWith("xlsx")){
            log.error(fileName + "不是excel文件");
        }
    }


    /**
     * 创建workbook对象
     *
     * @param file
     * @return
     */
    public static Workbook getWorkBook(String file) {
        //获得文件名
        String extString = file.substring(file.lastIndexOf("."));
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        //获取excel文件的io流
        InputStream is = null;
        try {
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            is = new FileInputStream(file);
            if (".xls".equals(extString)) {
                //2003
                workbook = new HSSFWorkbook(is);
            } else if (".xlsx".equals(extString)) {
                //2007 及2007以上
                workbook = new XSSFWorkbook(is);
            } else {
                return workbook = null;
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return workbook;
    }

    /**
     * 读取列的值
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        //判断数据的类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = stringDateProcess(cell);
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    public static String stringDateProcess(Cell cell) {
        String result = new String();
        if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
            SimpleDateFormat sdf = null;
            if (cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
                sdf = new SimpleDateFormat("HH:mm");
            } else {// 日期
                sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            }
            Date date = cell.getDateCellValue();
            result = sdf.format(date);
        } else if (cell.getCellStyle().getDataFormat() == 58) {
            // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            double value = cell.getNumericCellValue();
            Date date = org.apache.poi.ss.usermodel.DateUtil
                    .getJavaDate(value);
            result = sdf.format(date);
        } else {
            double value = cell.getNumericCellValue();
            CellStyle style = cell.getCellStyle();
            DecimalFormat format = new DecimalFormat();
            String temp = style.getDataFormatString();
            // 单元格设置成常规
            if (temp.equals("General")) {
                format.applyPattern("#");
            }
            result = format.format(value);
        }
        return result;
    }

}
