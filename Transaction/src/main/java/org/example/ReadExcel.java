package org.example;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcel {
    private static final int COLUM_INDEX_TYPE = 0;
    private static final int COLUM_INDEX_ACCOUNT = 1;
    private static final int COLUM_INDEX_AMOUNT = 2;
    private static final int COLUM_INDEX_MESSAGE = 3;
    private static final int COLUM_INDEX_DATE = 4;

    public static void main(String[] args) throws IOException {
        final String excelFilePath = "transaction.xlsx";
        final List<Transaction> transactionList = readExcel(excelFilePath);
        for (Transaction transaction: transactionList) {
            System.out.println(transaction);
        }
    }
    public  static List<Transaction> readExcel(String excelFilePath) throws IOException {
        List<Transaction> transactionList = new ArrayList<>();
        //get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = getWorkbook(inputStream,excelFilePath);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()){
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0){
                //bo qua dong tieu de
                continue;
            }
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            //Read cell and set value
            Transaction transaction = new Transaction();
            while (cellIterator.hasNext()){
                //read cell
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()){
                    continue;
                }
                //set value
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case COLUM_INDEX_TYPE:
                        transaction.setType((String) getCellValue(cell));
                        break;
                    case COLUM_INDEX_ACCOUNT:
                        transaction.setAccount((String) getCellValue(cell));
                        break;
                    case COLUM_INDEX_AMOUNT:
                        transaction.setAmount(new BigDecimal((double) cellValue).intValue());
                        break;
                    case COLUM_INDEX_MESSAGE:
                        transaction.setMessage((String) getCellValue(cell));
                        break;
                    case COLUM_INDEX_DATE:
                        transaction.setDateTime(LocalDateTime.parse((String) getCellValue(cell)));
                        break;
                    default:
                        break;
                }
                }
                transactionList.add(transaction);
            }
            workbook.close();
            inputStream.close();
            return transactionList;
    }
    private static Workbook getWorkbook(InputStream inputStream,String excelFile) throws IOException {
        Workbook workbook = null;
        if (excelFile.endsWith("xlsx")){
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFile.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }else {
            throw new IllegalArgumentException("The file is not Excel file");
        }
        return workbook;
    }
    private static Object getCellValue(Cell cell){
        CellType cellType = cell.getCellTypeEnum();
        Object cellValue = null;
        switch (cellType){
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
            case _NONE:
            case BLANK:
            case ERROR:
                break;
            default:
                break;
        }
        return cellValue;
    }
}
