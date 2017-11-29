package com.netcracker.xlsxwriter;

import com.netcracker.handlers.SortTimeHandler;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class write time and crate chart from SortTimeHandler to excel file
 *
 * @author Michael Rudyy
 * @version 1.5
 * @see SortTimeHandler
 */

public class XLSXWriter {

    /**
     * Path and name of create excel file.
     */
    private String fileName;

    /**
     * Constructor.
     *
     * @param fileName - path and name of create excel file
     */
    public XLSXWriter(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Create and write data about sort and sort time.
     * Create chart.
     *
     * @param mainList - list of list that handle analyzed data
     */
    public void writeTimeToFile(List<List<SortTimeHandler>> mainList) {

        XSSFWorkbook workbook = new XSSFWorkbook();

        for (List<SortTimeHandler> list : mainList) {
            XSSFSheet sheet = workbook.createSheet(list.get(0).getTypeOfArray());

            List<Object[]> dataList = new ArrayList<>();
            for (SortTimeHandler element : list) {
                dataList.add(new String[]{element.getTypeOfSort(), String.valueOf(element.getTimeOfExecution())});
            }

            int rowNum = 0;

            for (Object[] datatype : dataList) {
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;
                Cell cell = row.createCell(colNum++);
                cell.setCellValue((String) datatype[0]);
                cell = row.createCell(colNum++);
                cell.setCellValue(Integer.parseInt(datatype[1].toString()));
            }

            addChart(sheet, dataList.size() - 1);

        }

        try {
            FileOutputStream outputStream = new FileOutputStream(this.fileName);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method add chart to sheet
     *
     * @param sheet        - sheet where should create chart
     * @param numberOfRows - number of filled rows
     */

    private void addChart(XSSFSheet sheet, int numberOfRows) {
        Drawing<?> drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 15);

        Chart chart = drawing.createChart(anchor);
        LineChartData data = chart.getChartDataFactory().createLineChartData();

        ValueAxis bottomAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.BOTTOM);
        ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

        ChartDataSource<String> sortName = DataSources.fromStringCellRange(sheet, new CellRangeAddress(0, numberOfRows, 0, 0));
        ChartDataSource<Number> sortTime = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(0, numberOfRows, 1, 1));


        data.addSeries(sortName, sortTime);
        chart.plot(data, bottomAxis, leftAxis);
    }


}
