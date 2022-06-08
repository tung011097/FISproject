package org.example;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.print.Book;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WriteExcel {
    private static final int COLUM_INDEX_TYPE = 0;
    private static final int COLUM_INDEX_ACCOUNT = 1;
    private static final int COLUM_INDEX_AMOUNT = 2;
    private static final int COLUM_INDEX_MESSAGE = 3;
    private static final int COLUM_INDEX_DATE = 4;
    private static CellStyle cellStyle = null;

    public static void main(String[] args) throws IOException {
        final List<Transaction> transactions = getTransactionList();
        final String excelFile = "./transaction.xlsx";
        writeExcel(transactions, excelFile);
    }

    public static void writeExcel(List<Transaction> transactionList, String excelFile) throws IOException {
        Workbook workbook = getWorkbook(excelFile);
        Sheet sheet = workbook.createSheet("Transaction");// Create sheet name Transaction
        int rowIndex = 0;
        writeHeader(sheet, rowIndex);
        rowIndex++;
        for (Transaction transaction : transactionList) {
            Row row = sheet.createRow(rowIndex);
            writeTransaction(transaction, row);
            rowIndex++;
        }
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
        createOutputFile(workbook, excelFile);
        System.out.printf("DONE!!");
    }

    public static List<Transaction> getTransactionList() {
        List<Transaction> transactionList = new ArrayList<>();
        Transaction transaction1 = new Transaction("TYPE1","11111",3300000,"1111_A",LocalDateTime.now());
        Transaction transaction2 = new Transaction("TYPE2","22222",1200000,"2222_B",LocalDateTime.now());
        Transaction transaction3 = new Transaction("TYPE3","33333",3300000,"3333_C",LocalDateTime.now());
        Transaction transaction4 = new Transaction("TYPE4","44444",3300000,"4444_D",LocalDateTime.now());
        Transaction transaction5 = new Transaction("TYPE5","55555",3300000,"5555_F",LocalDateTime.now());
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        transactionList.add(transaction4);
        transactionList.add(transaction5);
        return transactionList;
    }

    public static Workbook getWorkbook(String excelFile) {
        Workbook workbook = null;
        //ket thuc file bang duoi xlsx
        if (excelFile.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFile.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The file not Excel");
        }
        return workbook;
    }

    public static void writeHeader(Sheet sheet, int rowIndex) {
        //create Cellstyle
        CellStyle cellStyle = createStyleForHeader(sheet);
        //Create row
        Row row = sheet.createRow(rowIndex);

        //Create cells
        Cell cell = row.createCell(COLUM_INDEX_TYPE);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Type");

        cell = row.createCell(COLUM_INDEX_ACCOUNT);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("ACCOUNT");

        cell = row.createCell(COLUM_INDEX_AMOUNT);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("AMOUNT");

        cell = row.createCell(COLUM_INDEX_MESSAGE);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("MESSAGE");

        cell = row.createCell(COLUM_INDEX_DATE);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("DATE");
    }

    public static void writeTransaction(Transaction transaction, Row row) {
        if (cellStyle == null) {
            short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");

            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyle = workbook.createCellStyle();
            cellStyle.setDataFormat(format);
        }
        Cell cell = row.createCell(COLUM_INDEX_TYPE);
        cell.setCellValue(transaction.getType());

        cell = row.createCell(COLUM_INDEX_ACCOUNT);
        cell.setCellValue(transaction.getAccount());

        cell = row.createCell(COLUM_INDEX_AMOUNT);
        cell.setCellValue(transaction.getAmount());

        cell = row.createCell(COLUM_INDEX_MESSAGE);
        cell.setCellValue(transaction.getMessage());

        cell = row.createCell(COLUM_INDEX_DATE);
        cell.setCellValue(transaction.getDateTime().toString());

    }

    public static CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14);
        font.setColor(IndexedColors.WHITE.getIndex());

        //Create Cellstyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }

    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

    private static void createOutputFile(Workbook workbook, String excelFile) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFile)) {
            workbook.write(os);
        }
    }
}
