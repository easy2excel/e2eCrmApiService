package com.easy2excel.crm;

import lombok.extern.slf4j.Slf4j;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootApplication(scanBasePackages = "com.easy2excel.crm")
@Slf4j
public class E2ecrmApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(E2ecrmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hiiiii");
	}
}
