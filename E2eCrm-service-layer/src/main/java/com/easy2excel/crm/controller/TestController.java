package com.easy2excel.crm.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
public class TestController {
    @GetMapping("/test")
    public List<List<String>> m1() throws IOException {
        InputStream file = new FileInputStream(new File("C:\\Users\\anilk\\Downloads\\FUSION1.xlsx"));


        Workbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);


        List<Row> rows = StreamSupport.stream(Spliterators.spliteratorUnknownSize(sheet.rowIterator(), 0), false)
                .collect(Collectors.toList());

        List<List<String>> s = rows.stream().map(cells -> {
            List<String> rowList = new ArrayList<>();
            //cells.cellIterator()

            Iterator<Cell> sx = cells.cellIterator();
          Stream<Cell> s1 = StreamSupport.stream(Spliterators.spliteratorUnknownSize(cells.cellIterator(), 0), false);


            s1.forEach(cell -> {
                DataFormatter formatter = new DataFormatter();
                rowList.add(formatter.formatCellValue(cell));
            });
                   /* s1.map(cell -> {
                        System.out.println("cell.getStringCellValue() "+cell.getStringCellValue());
                        return null;
                    });*/
            return rowList;
        }).collect(Collectors.toList());
        file.close();
        return s;
    }

    @PostMapping("/")
    public String saveData() {
        return "save";
    }

    @GetMapping("/tets2")
    public String m2() {
        return "22222";
    }
}
